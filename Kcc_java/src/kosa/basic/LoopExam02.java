package kosa.basic;

public class LoopExam02 {

	public static void main(String[] args) {
		// 중첩 for문
		// 전체 구구단 출력
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}

		// 퀴즈> 4x + 5y = 60 => x,y를 구하자(모든 경우의 수)
		for (int i = 0; i <= 15; i++) {
			for (int j = 0; j <= 12; j++) {
				if ((4 * i) + (5 * j) == 60) {
					System.out.println(i + ", " + j);
				}
			}
		}
	
		outerLabel:
		for (int i = 0; i <= 15; i++) {
			for (int j = 0; j <= 12; j++) {
				if ((4 * i) + (5 * j) == 60) {
					System.out.println(i + ", " + j);
					break outerLabel;
				}
			}
		}
		
		// 퀴즈>
		// *
		// **
		// ***
		// ****
		// *****
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 퀴즈>
		// *****
		// ****
		// ***
		// **
		// *
		for(int i = 5; i >= 1; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
