package kosa.oop3;

public class Runner {

	public static void main(String[] args) {

		Person p1 = new Person("철원", new Role() {

			@Override
			public void doing() {
				System.out.println("드라이빙 역할");
			}
		});

		Person p2 = new Person("재원", new Role() {

			@Override
			public void doing() {
				System.out.println("직장 역할");
			}
		});

		Person p3 = new Person("황재원", () -> System.out.println("람다식 역할"));

		p1.doit();
		p2.doit();
		p3.doit();
	}

}
