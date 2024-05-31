package kosa.subject.oop.phoneInfo;

import java.util.Scanner;

import kosa.oop.phoneInfo.DataInput;

public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		Scanner sc = DataInput.getInstance();

		flag: while (true) {
			System.out.println(">1.추가 2.전체출력 3.검색 4.수정 5.삭제 6.종료");
			System.out.print(">메뉴: ");
			int cmd = Integer.parseInt(sc.next());

			switch (cmd) {
			case 1:
				manager.addPhoneInfo();
				break;
			case 2:
				manager.listPhoneInfo();
				break;
			// 나중에
			case 3:
				System.out.print(">�˻� �̸�: ");
				String iptName = sc.nextLine();

				try {
					PhoneInfo searchedPhoneInfo = manager.searchPhoneInfo(iptName);
					searchedPhoneInfo.printInfo();
				} catch (NullPointerException e) {
					System.out.println("��ȭ��ȣ�� ã�� ���߽��ϴ�.");
				}

				break;
			case 4:
				System.out.println("서비스 종료");
				break flag;
			default:
				System.out.println("1~5번 중 하나를 입력해주세요.");
			}
		}
	}

}
