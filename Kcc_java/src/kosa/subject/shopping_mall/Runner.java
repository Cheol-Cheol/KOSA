package kosa.subject.shopping_mall;

import java.util.Scanner;

import kosa.subject.shopping_mall.domain.ShoppingMall;

public class Runner {

	public static void main(String[] args) {

		ShoppingMall shoppingMall = new ShoppingMall();
		Scanner sc = new Scanner(System.in);

		// 로그인(관리자: admin)
		System.out.print("[로그인] 닉네임을 입력하시오: ");
		shoppingMall.login(sc.next());

		int cmd;
		while (true) {
			System.out.println("=================================메뉴=======================================");
			System.out.println("| (1) 고객 등록              (2) 고객 전체 출력             (3) 상품 등록         |");
			System.out.println("| (4) 상품 전체 출력          (5) 장바구니에 상품 추가         (6) 장바구니 내역 출력  |");
			System.out.println("| (7) 주문 생성              (8) 주문 목록 출력             (9) 카테고리별 목록 출력 |");
			System.out.println("===========================================================================");
			System.out.print(">");
			cmd = Integer.parseInt(sc.next());

			switch (cmd) {
				// 고객 등록
				case 1:
					System.out.println("\n#고객 등록");
					System.out.println("[1/4] 등록할 고객의 '이름'을 입력해주세요.");
					System.out.print(">");
					String username = sc.next();
					System.out.println("[2/4] 등록할 고객의 '닉네임'을 입력해주세요.");
					System.out.print(">");
					String nickname = sc.next();
					System.out.println("[3/4] 등록할 고객의 '나이'를 입력해주세요.");
					System.out.print(">");
					int age = Integer.parseInt(sc.next());
					sc.nextLine();
					System.out.println("[4/4] 등록할 고객의 '주소'를 입력해주세요.");
					System.out.print(">");
					String addr = sc.nextLine();

					shoppingMall.createUser(username, nickname, age, addr);
					break;
				// 고객 목록
				case 2:
					System.out.println("\n#고객 목록");
					shoppingMall.getUserList();
					break;
				// 상품 등록
				case 3:
					System.out.println("\n#상품 등록");
					System.out.println("[1/3] 등록할 상품의 '상품명'을 입력해주세요.");
					System.out.print(">");
					String productName = sc.next();
					System.out.println("[2/3] 등록할 상품의 '가격'을 입력해주세요.");
					System.out.print(">");
					int price = Integer.parseInt(sc.next());
					System.out.println("[3/3] 등록할 상품의 '카테고리 번호'를 입력해주세요.");
					System.out.println("(1) 상의\n(2) 하의\n(3) 아우터\n(4) 악세사리\n(5) 신발");
					System.out.print(">");
					int categoryIdx = Integer.parseInt(sc.next());

					shoppingMall.createProduct(productName, price, categoryIdx);
					break;
				// 상품 조회
				case 4:
					System.out.println("\n#판매중인 상품 목록");
					shoppingMall.getProductList();
					break;
				// 장바구니 상품 추가
				case 5:
					System.out.println("\n#장바구니");
					System.out.println("장바구니에 추가할 상품의 'id'를 입력해주세요.");
					System.out.print(">");
					int productId = Integer.parseInt(sc.next());

					shoppingMall.addCartItem(productId);
					break;
				// 장바구니 내역
				case 6:
					shoppingMall.getCartListByUser();
					break;
				// 상품 주문
				case 7:
					shoppingMall.createOrder();
					break;
				// 주문 목록 출력
				case 8:
					shoppingMall.getOrderListByUser();
					break;
				// 카테고리별 목록 출력
				case 9:
					xx:
					while (true) {
						System.out.println(
							"--------------------------------------------------------------------------");
						System.out.println("원하시는 '카테고리 번호'를 입력해주세요.");
						System.out.println("(1) 상의\t\t(2) 하의\t\t(3) 아우터\t(4) 악세사리\t\t(5) 신발\t\t(6) 종료");
						System.out.println(
							"--------------------------------------------------------------------------");
						System.out.print(">");
						cmd = Integer.parseInt(sc.next());

						switch (cmd) {
							case 1:
							case 2:
							case 3:
							case 4:
							case 5:
								shoppingMall.getFilterProductList(cmd);
								break;
							case 6:
								System.out.println("[서비스 알림] 카테고리별 조회 종료\n");
								break xx;
							default:
								System.out.println("[서비스 알림] 1~6번중 하나를 입력해주세요.");
						}
					}
			}
		}
	}
}
