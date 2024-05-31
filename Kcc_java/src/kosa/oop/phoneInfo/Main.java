package kosa.oop.phoneInfo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = DataInput.getInstance(); // 싱글톤
		Manager manager = new Manager();

		while (true) {
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				manager.addPhoneInfo();
				break;
			case "2":
				manager.listPhoneInfo();
				break;
			case "3":
				return;
			}
		}
	}
}
