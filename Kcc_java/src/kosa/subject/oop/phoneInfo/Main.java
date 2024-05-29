package kosa.subject.oop.phoneInfo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();

		flag: while (true) {
			System.out.println(">1.추가 2.전체출력 3.검색 4.종료");
			System.out.print(">메뉴: ");
			int cmd = Integer.parseInt(sc.nextLine());

			switch (cmd) {
			case 1:
				System.out.print(">이름: ");
				String name = sc.nextLine();
				System.out.print(">전화번호: ");
				String tel = sc.nextLine();
				System.out.print(">생년월일: ");
				String birth = sc.nextLine();

				manager.addPhoneInfo(name, tel, birth);
				break;
			case 2:
				manager.listPhoneInfo();
				break;
			case 3:
				System.out.print(">검색 이름: ");
				String iptName = sc.nextLine();

				try {
					PhoneInfo searchedPhoneInfo = manager.searchPhoneInfo(iptName);
					searchedPhoneInfo.printPhoneInfo();
				} catch (NullPointerException e) {
					System.out.println("전화번호를 찾지 못했습니다.");
				}

				break;
			case 4:
				break flag;
			default:
				System.out.println("다시 입력해주세요.");
			}
		}
	}

}
