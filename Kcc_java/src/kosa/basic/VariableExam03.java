package kosa.basic;

public class VariableExam03 {

	public static void main(String[] args) {
		// 지역(로컬)변수 특징 2가지
		// 1. 반드시 초기화 후 사용해야 한다.
		// 2. 선언된 변수는 정의된 범위 안에서만 사용 가능하다.

		int num = 0;

		num = num + 1;
		System.out.println(num);

		int a = 0;
		if (num == 1) {
			a = 100;
		}

		System.out.println("a: " + a);

		int i = 1;
		for (; i <= 10; i++) {
			System.out.print(i + ", ");
		}

		System.out.println(i);

		// 변수 사용 시 고민
		// 1. 어떤 종류의 데이터? => 데이터 타입 선언 결정
		// 2. 데이터 사용 범위 => 변수 선언 위치 결정

		// 연산자 %
		System.out.println(10 % 3);

		if (11 % 2 == 0) {
			System.out.println("2의 배수 O");
		} else {
			System.out.println("2의 배수 X");
		}

		// 복합 대입 연산자
		int num2 = 1;
		num2 += 1;

		// 증감 연산자
		num2++;

		System.out.println(num2);

		int b = 10;
		int c = 20;

		int max = (b > c) ? b : c;

		System.out.println(max);
	}

}
