package kosa.mission;

import java.util.Scanner;

public class Mission05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		xx: while (true) {
			System.out.println("---------1. 추가 2. 출력 3. 검색 4. 종료---------");
			System.out.print("명령어 입력: ");
			int cmd = Integer.parseInt(sc.nextLine());

			switch (cmd) {
			case 1:
				System.out.println(">>> 메뉴 추가\n");
				break;
			case 2:
				System.out.println(">>> 출력\n");
				break;
			case 3:
				System.out.println(">>> 검색\n");
				break;
			case 4:
				System.out.println(">>> 종료\n");
				break xx;
			}

		}

	}

}
