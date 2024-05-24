package kosa.mission;

import java.util.Scanner;

public class Mission03 {

	public static void main(String[] args) {
		// 임의의 정수값에 대해 전체 자리수 중 짝수, 홀수의 개수를 구하자.
		// 5자리수 ex) 12345
		Scanner sc = new Scanner(System.in);
		String strNum = sc.nextLine();

		int evenCnt = 0;
		int oddCnt = 0;
		for (int i = 0; i < strNum.length(); i++) {
			if ((int) strNum.charAt(i) % 2 == 0) {
				evenCnt++;
			} else {
				oddCnt++;
			}
		}

		System.out.println("짝수의 개수: " + evenCnt + "개");
		System.out.println("홀수의 개수: " + oddCnt + "개");
	}

}
