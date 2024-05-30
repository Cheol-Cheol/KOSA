package kosa.oop.member;

public class Member {
	// 회원정보에 대한 클래스와 객체를 생성 후 출력해보기
	private String name;
	private int age;
	private String addr;

	public Member() {
	}

	public Member(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

}
