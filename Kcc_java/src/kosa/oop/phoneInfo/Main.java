package kosa.oop.phoneInfo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = DataInput.getInstance(); // 싱글톤
		Manager manager = new Manager();

		while (true) {
			System.out.println("1. 추가 | 2. 전체 출력 | 3. 정렬 | 4. 종료 | 7. 데이터 저장 | 8. 데이터 불러오기");
			System.out.print(">");
			String menu = sc.next();

			switch (menu) {
			case "1":
				manager.addPhoneInfo();
				break;
			case "2":
				manager.listPhoneInfo();
				break;
			case "3":
				manager.sortPhoneInfo();
				break;
			case "4":
				return;
			case "7":
				manager.insertData();
				break;
			case "8":
				manager.getData();
				break;
			}
		}
	}
}
