package kosa.mission;

import java.util.Scanner;

public class Mission04 {

	public static void main(String[] args) {
		// 문자열 비교
		String a = "abc";
		String b = "abc";

		if (a.equals(b)) {
			System.out.println("같다");
		} else {
			System.out.println("틀리다");
		}

		// 두 정수와 연산자 문자열을 입력 받아
		// 사칙연산 결과를 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수1: ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("정수2: ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("연산자: ");
		String operator = sc.nextLine();

		int result = -1;
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}

		System.out.println("결과> " + result);
	}

}
