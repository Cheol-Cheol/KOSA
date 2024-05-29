package kosa.relation;

public class Runner {

	public static void main(String[] args) {
		Course c1 = new Course("전산학개론");
		Course c2 = new Course("기초통계학");
		Course c3 = new Course("빅데이터개론");

		Student s1 = new Student("황철원");
		Student s2 = new Student("유재원");

		s1.register(c1);
		s1.register(c2);

		s2.register(c2);
		s2.register(c3);

		s2.dropCourse(c3);

		s1.printMember();
		System.out.println();
		s2.printMember();
		System.out.println("=============");

		c2.printCourse();
	}

}
