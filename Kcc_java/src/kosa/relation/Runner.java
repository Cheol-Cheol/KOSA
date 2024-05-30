package kosa.relation;

public class Runner {

	public static void main(String[] args) {
		Course c1 = new Course("�����а���");
		Course c2 = new Course("���������");
		Course c3 = new Course("�����Ͱ���");

		Student s1 = new Student("Ȳö��");
		Student s2 = new Student("�����");

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