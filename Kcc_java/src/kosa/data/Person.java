package kosa.data;

public class Person implements Comparable<Person> {

	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
		// 나이를 기준으로 오름차순
//		if (this.age > o.getAge()) {
//			return 1;
//		} else if (this.age < o.getAge()) {
//			return -1;
//		}
//		return 0;
		return Integer.compare(this.age, o.getAge());
	}

}
