package kosa.subject.baseball;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBalls baseBalls = new BaseBalls();
		System.out.println("서로 다른 세 자리 숫자를 입력하시오.");

		int cnt = 1;
		while (true) {
			System.out.print("답지: ");
			baseBalls.printAnswer();
			System.out.println();
			//
			System.out.print("입력> ");
			int iptNum = Integer.parseInt(sc.next());

			// 정답 체크
			String result = baseBalls.checkAnswer(iptNum);
			if (result.equals("3Strike")) {
				System.out.println(cnt + "번째 성공");
				break;
			} else {
				cnt++;
				System.out.println("결과> " + result);
			}
		}
	}
}
