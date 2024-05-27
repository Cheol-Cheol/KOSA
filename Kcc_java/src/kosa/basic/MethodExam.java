package kosa.basic;

public class MethodExam {

	// 메서드 정의(for 재사용성)
	// 접근 제어자, (static), 리턴형(void), 메서드이름(파라미터(인자))

	public static void main(String[] args) {
		repeatChar('#', 10);
		repeatChar('!', 4);
		repeatChar('*', 20);

		int sum = add(10, 20);
		System.out.println(sum);
	}

	public static void repeatChar(char word, int len) {
		for (int i = 1; i <= len; i++) {
			System.out.print(word);
		}
		System.out.println();
	}

	public static int add(int num1, int num2) {
		int sum = num1 + num2;
//		System.out.println(sum);
		return sum;
	}
}
