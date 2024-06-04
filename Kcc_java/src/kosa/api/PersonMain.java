package kosa.api;

public class PersonMain {

	public static void main(String[] args) {

		Person p1 = new Person("홍길동", 30);
		Person p2 = new Person("홍길동", 20);

		if (p1.equals(p2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		System.out.println(p1);

	}

}
