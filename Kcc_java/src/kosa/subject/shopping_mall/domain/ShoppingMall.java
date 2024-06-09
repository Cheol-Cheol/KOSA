package kosa.subject.shopping_mall.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kosa.subject.shopping_mall.constants.Category;
import kosa.subject.shopping_mall.utils.Dummy;
import kosa.subject.shopping_mall.utils.ProductValidation;
import kosa.subject.shopping_mall.utils.UserValidation;

public class ShoppingMall {

	private User loginUser;

	private final Queue<Order> orderList;
	private final List<Product> productList;
	private final List<User> userList;

	public ShoppingMall() {
		this.orderList = new LinkedList();
		this.productList = new ArrayList(Dummy.setProductData());
		this.userList = new LinkedList(Dummy.setUserData());
	}

	// 고객 등록하기 [v]
	public void createUser(String name, String nickname, int age, String addr) {
		try {
			if (!isUserValid(name, nickname, age, addr)) {
				return;
			} else {
				userList.add(new User(name, nickname, age, addr));
				System.out.println("[서비스 알림] 고객 등록 성공\n");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	// 상품 등록하기 [v]
	public void createProduct(String name, int price, int categoryIdx) {
		try {
			if (!isProductValid(name, price)) {
				return;
			} else {
				Category category = Category.values()[categoryIdx - 1];
				productList.add(new Product(name, price, category));
				System.out.println("[서비스 알림] 상품 등록 성공\n");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	// 상품 장바구니 담기 [v]
	public void addCartItem(int productId) {
		for (Product product : productList) {
			if (product.getProductId() == productId) {
				loginUser.addCartItem(product);
				product.setStock(product.getStock() - 1);
				System.out.println("[서비스 알림] 장바구니에 추가 완료\n");
				return;
			} else {
				continue;
			}
		}
		System.out.println("[서비스 알림] 장바구니에 추가할 상품을 찾지 못했습니다.\n");
	}

	// 상품 주문하기 [v]
	public void createOrder() {
		if (loginUser.getCart().isEmpty()) {
			System.out.println("[서비스 알림] 장바구니가 비어있어 주문을 생성할 수 없습니다.\n");
			return;
		}
		Order order = new Order(loginUser);
		orderList.offer(order);
		loginUser.getOrderList().add(order);
		loginUser.getCart().clear();
		order.startDelivery();
		System.out.println("[서비스 알림] 주문을 생성하였습니다.\n");
	}

	// 상품 카테고리별 목록 보기 [v]
	public void getFilterProductList(int categoryIdx) {
		Category category = Category.values()[categoryIdx - 1];

		System.out.println("\n#" + category.getValue() + "별 조회");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%s    %-13s      %-13s     %-13s  %s\n", "ID", "상품명", "가격", "재고", "카테고리");
		System.out.println("------------------------------------------------------------------------------------");
		for (Product product : productList) {
			if (product.getCategory().name().equals(category.name())) {
				System.out.println(product.printProductInfo());
			}
		}

		System.out.println("------------------------------------------------------------------------------------\n");
	}

	// 회원의 주문 목록 보기 [v]
	public void getOrderListByUser() {
		if (loginUser.getOrderList().isEmpty()) {
			System.out.println("[서비스 알림] 주문 목록이 비었습니다.\n");
			return;
		}
		System.out.println("\n#" + loginUser.getName() + "님의 주문 목록");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%s     %-5s        %-5s    		%-5s\n", "ID", "배송상태", "이름", "주문날짜");
		System.out.println("------------------------------------------------------------------------------------");

		for (Order order : loginUser.getOrderList()) {
			System.out.println(order.printOrderInfo());
		}

		System.out.println("------------------------------------------------------------------------------------\n");
	}

	// 장바구니 내역 출력 [v]
	public void getCartListByUser() {
		if (loginUser.getCart().isEmpty()) {
			System.out.println("[서비스 알림] 장바구니가 비었습니다.\n");
			return;
		}
		System.out.println("\n#장바구니 내역");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%s    %-13s 				%s\n", "ID", "상품명", "가격");
		System.out.println("------------------------------------------------------------------------------------");

		int totalPrice = 0;
		for (Product product : loginUser.getCart()) {
			totalPrice += product.getPrice();
			System.out.println(product.printProductFromCart());
		}

		System.out.println("==============================================");
		System.out
				.println("                                                        			[총계] " + totalPrice + "원");
		System.out.println("------------------------------------------------------------------------------------\n");
	}

	// 로그인 하기 [v]
	public void login(String nickname) {
		for (User user : userList) {
			if (user.getNickname().equals(nickname.trim())) {
				loginUser = user;

				System.out.println(
						"------------------------------------------------------------------------------------");
				System.out.println("[서비스 알림] " + user.getName() + "님이 로그인되었습니다.");
				System.out.println(
						"------------------------------------------------------------------------------------\n");
			}
		}
	}

	// 고객 전체 출력 [v]
	public void getUserList() {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%s    %s    %-15s 	  %s       %-20s  %s\n", "ID", "고객명", "닉네임", "나이", "주소", "가입날짜");
		System.out.println("------------------------------------------------------------------------------------");

		for (User user : userList) {
			System.out.println(user.printUserInfo());
		}

		System.out.println("------------------------------------------------------------------------------------\n");
	}

	// 상품 전체 출력 [v]
	public void getProductList() {
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%s    %-13s      %-13s    %-13s  %s\n", "ID", "상품명", "가격", "재고", "카테고리");
		System.out.println("------------------------------------------------------------------------------------");

		for (Product product : productList) {
			System.out.println(product.printProductInfo());
		}

		System.out.println("------------------------------------------------------------------------------------\n");
	}

	// 회원 유효성 검사 [v]
	private static boolean isUserValid(String name, String nickname, int age, String addr)
			throws IllegalArgumentException {
		return UserValidation.isValidName(name) && UserValidation.isValidNickname(nickname)
				&& UserValidation.isValidAge(age) && UserValidation.isValidAddr(addr);
	}

	// 상품 유효성 검사 [v]
	private static boolean isProductValid(String name, int price) throws IllegalArgumentException {
		return ProductValidation.isValidName(name) && ProductValidation.isValidPrice(price);
	}

}
