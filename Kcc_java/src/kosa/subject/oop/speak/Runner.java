package kosa.subject.oop.speak;

public class Runner {

	public static void main(String[] args) {

		Object[] obj = { new Reader("둘리"), new Work("길동"), new Student("마이콜") };

		for (Object o : obj) {
			if (o instanceof Speakable) {
				System.out.println(((Speakable) o).speak());
			}
		}
	}

}
