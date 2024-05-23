package kosa.basic;

import java.util.Scanner;

public class VariableExam02 {

	public static void main(String[] args) {
		// 키보드로부터 데이터 입력
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력: ");
		int num = Integer.parseInt(sc.nextLine());

		System.out.print("문자열 입력: ");
		String str = sc.nextLine();

		System.out.println(num);
		System.out.println(str);

		// A~Z (for문 이용) 전체 출력
		for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		
		// int <==> String
		String num2 = "100";
		int num3 = Integer.parseInt(num2);
		int result = num3 + 100;
		System.out.println(result);
		
		int num4 = 10;
		String num5 = String.valueOf(num4);
		String num6 = num4 + "";
	
		String str2 = 7 +"7" + 7;
		System.out.println(str2);
	}
}
