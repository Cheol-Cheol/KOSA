package kosa.phone;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		while (true) {
			System.out.println("1.�߰� 2.��ü��� 3.����");
			System.out.print("�޴��Է�: ");
			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				manager.addPhoneInfo();
				break;
			case "2":
				manager.listPhoneInfo();
				break;
			case "3":
				System.out.println("���α׷� ����");
				return;
			}
		}
	}
}
