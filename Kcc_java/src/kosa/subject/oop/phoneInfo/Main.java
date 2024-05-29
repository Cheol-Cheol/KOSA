package kosa.subject.oop.phoneInfo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		flag: while (true) {
			System.out.println(">1.�߰� 2.��ü��� 3.�˻� 4.����");
			System.out.print(">�޴�: ");
			int cmd = Integer.parseInt(sc.nextLine());

			switch (cmd) {
			case 1:
				System.out.print(">�̸�: ");
				String name = sc.nextLine();
				System.out.print(">��ȭ��ȣ: ");
				String tel = sc.nextLine();
				System.out.print(">�������: ");
				String birth = sc.nextLine();

				manager.addPhoneInfo(name, tel, birth);
				break;
			case 2:
				manager.listPhoneInfo();
				break;
			case 3:
				System.out.print(">�˻� �̸�: ");
				String iptName = sc.nextLine();

				try {
					PhoneInfo searchedPhoneInfo = manager.searchPhoneInfo(iptName);
					searchedPhoneInfo.printPhoneInfo();
				} catch (NullPointerException e) {
					System.out.println("��ȭ��ȣ�� ã�� ���߽��ϴ�.");
				}

				break;
			case 4:
				break flag;
			default:
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}

}
