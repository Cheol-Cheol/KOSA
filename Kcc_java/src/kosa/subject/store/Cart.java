package kosa.subject.store;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private Customer customer;
	private List<Product> products;

	public Cart() {
	}

	public Cart(Customer customer) {
		this.customer = customer;
		this.products = new ArrayList<>();
	}

	// 장바구니 추가
	public void addCart(Product product) {
		products.add(product);
	}

	// 장바구니 제거
	public void removeCart(Product product) {
		products.remove(product);
	}

	// 주문하기
	public void orderCart() {
		// 총 금액
		int totalPrice = 0;
		for (Product product : products) {
			totalPrice += product.getPrice();
		}

		int balance = customer.getBalance();
		if (totalPrice > balance) {
			System.out.println("금액이 부족합니다. 주문을 취소합니다.");
			return;
		} else {
			// 잔액 차감
			customer.setBalance(balance - totalPrice);
			// 재고 감소
			for (Product product : products) {
				product.setStock(product.getStock() - 1);
			}

			products.clear(); // 장바구니 비우기
			System.out.println("결제가 완료되었습니다. 결제 금액: " + totalPrice + "원" + " | 남은 금액: " + customer.getBalance() + "원");
		}

	}

	// 장바구니 내역 출력
	public void printCartInfo() {
		System.out.println(customer.getName() + "님의 장바구니");
		System.out.println("======================");

		int totalPrice = 0;
		for (Product product : products) {
			System.out.println("상품명: " + product.getName());
			System.out.println("가격: " + product.getPrice());
			totalPrice += product.getPrice();
			System.out.println("======================");
		}
		System.out.println("총 금액: " + totalPrice);
	}

}
