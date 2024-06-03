package kosa.oop5;

public class Main {

	public static void main(String[] args) {

		MyType my1 = new MyType() {

			@Override
			public void hello() {
				System.out.println("익명클래스 방식");
			}
		};
		my1.hello();

		MyType my2 = () -> System.out.println("람다식 방식");
		my2.hello();

		YourType you = (String message) -> {
			System.out.println("메시지: " + message);
		};
		you.talk("hi");

		YourType you2 = message -> System.out.println("메시지: " + message);
		you2.talk("hihi");

		// MyNumber 추상 메서드 구현(람다식)
		MyNumber myNum = (a, b) -> (a > b) ? a : b;
		System.out.println(myNum.getMax(3, 2));

		Runnable r1 = () -> {
			for (int i = 1; i <= 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
		};
		Thread t = new Thread(r1);
		t.start();
		
	}

}
