package kosa.subject.oop.restaurant;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Restaurant {

	public static void main(String[] args) throws IOException {

		Order order = new Order();
		ServiceInfo serviceInfo = new ServiceInfo();

		int cmd;
		while (true) {
			cmd = serviceInfo.printCommand();

			switch (cmd) {
			case 1:
				try {
					String foodName = serviceInfo.inputString("음식명");
					int price = serviceInfo.inputInt("가격");
					order.requestOrder(foodName, price);
				} catch (IllegalArgumentException e) {
					serviceInfo.printError(e);
				}
				break;
			case 2:
				try {
					order.executeOrder();
				} catch (NoSuchElementException e) {
					serviceInfo.printError(e);
				}
				break;
			case 3:
				order.getTotalIncome();
				break;
			case 4:
				serviceInfo.printExit();
				return;
			default:
				serviceInfo.printInvalid();
			}
		}
	}

}
