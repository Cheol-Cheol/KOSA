package kosa.oop5;

interface A {

	void abc();

}

class B {

	void bcd() {
		System.out.println("메서드 호출");
	}

}

public class Main2 {

	public static void main(String[] args) {

		// 1. 익명 클래스를 이용해서 abc() 오버라이딩 -> B를 생성해서 bcd() 호출하기
		A a = new A() {

			@Override
			public void abc() {
				B b = new B();
				b.bcd();
			}
		};
		a.abc();

		// 2. 람다식
		A aa = () -> {
			B b = new B();
			b.bcd();
		};
		aa.abc();

		// 3. 인스턴스 참조 구현
		B b = new B();
		A a3 = b::bcd;
		a3.abc();

	}

}
