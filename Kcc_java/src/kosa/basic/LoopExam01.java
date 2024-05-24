package kosa.basic;

import java.util.Scanner;

public class LoopExam01 {

	public static void main(String[] args) {
		// while: 초기식 -> 조건식 -> 명령문 -> 증감식
		// 1~10까지 합
		int sum = 0;
		int i = 1;
		while (i <= 10) {
			sum += i;
			i++;
		}

		System.out.println("1~10까지 합: " + sum);

		// 퀴즈>구구단 7단 출력
		int j = 1;
		while (j <= 9) {
			System.out.println("7 * " + j + " = " + 7 * j);
			j++;
		}

		// 퀴즈>1~100까지 2의 배수와 3의 배수가 아닌 숫자만 출력하시오.
		for (int k = 1; k <= 100; k++) {
			if (k % 2 == 0 || k % 3 == 0) {
				continue;
			}
			System.out.println(k);
		}

		// do~while: 명령문을 1번은 시작해야해서
		// 키보드로부터 숫자를 입력 받기
		// 음수를 입력하면 새로 입력 받도록 하기 위함
		Scanner sc = new Scanner(System.in);
//		int n = 0;
//		
//		do {
//			System.out.println("입력: ");
//			n = Integer.parseInt(sc.nextLine());
//		} while(n < 0);
//	
//		System.out.println("입력 결과: " + n);

		// 퀴즈> 2개의 정수를 입력 받아 b - a 결과 출력
		// b > a 되도록 입력 => a가b보다 크면 새로 입력받도록 하기

//		int a;
//		int b;
//		do {
//			a = Integer.parseInt(sc.nextLine());
//			b = Integer.parseInt(sc.nextLine());
//			
//			if (b > a) {
//				System.out.println(b - a);
//				continue;
//			}
//			
//		} while (a > b);
//		
		// 퀴즈> 임의의 난수 3개 받아서 서로 중첩되지 않고 출력하기
		while (true) {
			int randomA = (int) (Math.random() * 9) + 1;
			int randomB = (int) (Math.random() * 9) + 1;
			int randomC = (int) (Math.random() * 9) + 1;

			if (randomA == randomB || randomB == randomC || randomA == randomC) {
				continue;
			} else {
				System.out.println(randomA + " " + randomB + " " + randomC);
				break;
			}
		}
	}
}
