package kosa.subject.baseball;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBalls baseBalls = new BaseBalls();
		System.out.println("=======야구게임 시작========");
		System.out.println("서로 다른 세 자리 숫자를 입력하시오.");

		while (true) {
			System.out.print("답지: ");
			baseBalls.printAnswer();
			System.out.println();
			// 
			System.out.print("입력> ");
			int iptNum = Integer.parseInt(sc.next());

			// 정답 체크
			if (baseBalls.checkAnswer(iptNum)) {
				break;
			} else {
				continue;
			}
		}
	}

}
