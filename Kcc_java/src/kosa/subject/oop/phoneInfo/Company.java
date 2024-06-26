package kosa.subject.oop.phoneInfo;

public class Company extends PhoneInfo {

	private String dept;
	private String position;

	public Company() {
	}

	public Company(String name, String phoneNo, String birth, String dept, String position) {
		super(name, phoneNo, birth);
		this.dept = dept;
		this.position = position;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(">부서: " + dept);
		System.out.println(">직책: " + position);
	}

}
