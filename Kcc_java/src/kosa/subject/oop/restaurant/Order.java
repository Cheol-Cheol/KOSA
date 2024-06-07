package kosa.subject.oop.restaurant;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Order {

	private Queue<Food> orders;
	private int totalIncome;

	public Order() {
		orders = new LinkedList();
	}

	// 주문 추가
	public void requestOrder(final String foodName, final int price) throws IllegalArgumentException {
		if (!isValid(foodName, price)) {
			throw new IllegalArgumentException("음식명 공백이 아닌, 가격은 0원 이상으로 작성해주세요.");
		}

		orders.offer(new Food(foodName, price));
		System.out.println("주문이 추가되었습니다.");
	}

	// 주문 처리
	public void executeOrder() throws NoSuchElementException {
		if (orders.isEmpty()) {
			throw new NoSuchElementException("주문 리스트가 비어있습니다.");
		}

		Food order = orders.poll();
		totalIncome += order.getPrice();
		System.out.println("주문이 처리되었습니다. " + order);
	}

	// 매출액 총액
	public void getTotalIncome() {
		System.out.println(totalIncome + "원");
	}

	private static boolean isValid(final String foodName, final int price) {
		return foodName != null && price >= 0;
	}
}
