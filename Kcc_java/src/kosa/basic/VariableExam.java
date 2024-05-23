package kosa.basic;

public class VariableExam {

	public static void main(String[] args) {
		// 변수는 데이터를 담는 그릇 ex) 홍길동, 100, 3.14, true
		// byte, char, short, int, long, float, double, boolean : Primitive Type
		int num; // 변수 선언 : 메모리 할당
		int arr[]; // 배열 선언 : Object Type

		num = 10;

		// 변수 선언 및 초기화
		int num2 = 100;

		// 문자열: String
		String name = "홍길동";
		System.out.println(name);

		// 변수 선언 주의사항
		// 변수명 : 특수문자X, 숫자로 시작X, 소문자 시작, _

		// 기본 리터럴: 100은 기본 리터럴로 int형으로 되어있다. "" -> String형, '' -> char형, true -> boolean형, 31.4 -> double형
		float a = 3.14f; // 3.14 즉, float -> double로 캐스팅하기 위해 (float) 명시적으로 작성해줘야 하는데, 'f'라는 문자로 대체할 수 있다.
		
		// 캐스팅(형변환)
		double b = 100;
		int c = (int)3.14;
		System.out.println(c);
		
		float num3 = 3.14f;
		long num4 = 100L;
		
		int num5 = 010; // 8진법으로 10이 아닌, 8이 출력된다.
		System.out.println(num5);
		
	}

}
