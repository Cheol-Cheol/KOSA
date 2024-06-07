package kosa.subject.shopping_mall;

import java.util.Scanner;

import kosa.subject.shopping_mall.domain.ShoppingMall;
import kosa.subject.shopping_mall.domain.User;

public class Runner {

	private static User loginUser;

	public static void main(String[] args) {

		ShoppingMall shoppingMall = new ShoppingMall();
		Scanner sc = new Scanner(System.in);

		// 로그인(관리자: admin)
		System.out.print("닉네임을 입력하시오: ");
		shoppingMall.login(sc.next());

		int cmd;
		String name;
		while (true) {
			System.out.println("1. 고객 등록 | 2. 고객 전체 출력 | 3. 상품 등록 | 4. 상품 전체 출력");
			System.out.println("5. 장바구니에 상품 추가 | 6. 주문 생성 | 7. 장바구니 내역 출력 | 8. 회원의 주문 목록 출력");
			System.out.print(">");
			cmd = Integer.parseInt(sc.next());

			switch (cmd) {
			case 1:
				System.out.print("이름: ");
				name = sc.next();
				System.out.print("닉네임: ");
				String nickname = sc.next();
				System.out.print("나이: ");
				int age = Integer.parseInt(sc.next());
				System.out.print("주소: ");
				String addr = sc.next();
				//
				shoppingMall.createUser(name, nickname, age, addr);
				break;
			case 2:
				shoppingMall.getUserList();
				break;
			case 3:
				System.out.print("상품명: ");
				name = sc.next();
				System.out.print("가격: ");
				int price = Integer.parseInt(sc.next());
				System.out.println("카테고리를 선택해주세요.(1~5번 중 숫자 하나 입력)");
				System.out.println("1. 상의 | 2. 하의 | 3. 아우터 | 4. 악세사리 | 5. 신발");
				System.out.print("카테고리 번호: ");
				int categoryIdx = Integer.parseInt(sc.next());
				//
				shoppingMall.createProduct(name, price, categoryIdx);
				break;
			case 4:
				shoppingMall.getProductList();
				break;
			case 5:
				System.out.println("추가할 상품의 id를 입력해주세요.");
				System.out.print(">");
				int productId = Integer.parseInt(sc.next());
				shoppingMall.addCartItem(productId);
				break;
			case 6: // 주문 생성
				shoppingMall.createOrder();
				break;
			case 7:
				shoppingMall.getCartListByUser();
				break;
			case 8:
				shoppingMall.getOrderListByUser();
				break;
			}
		}
	}
}
