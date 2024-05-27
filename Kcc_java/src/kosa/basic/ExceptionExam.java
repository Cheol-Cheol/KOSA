package kosa.basic;

public class ExceptionExam {

	public static void noEquals(int a, int b) throws Exception {
		if (a == b) {
			throw new Exception("°°Àº °ª ¾ÈµÅ!");
		}
	}

	public static void main(String[] args) {
		try {
			noEquals(3, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("done...");
	}
}
