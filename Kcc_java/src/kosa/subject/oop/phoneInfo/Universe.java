package kosa.subject.oop.phoneInfo;

public class Universe extends PhoneInfo {

	private String major;
	private String year;

	public Universe() {
	}

	public Universe(String name, String phoneNo, String birth, String major, String year) {
		super(name, phoneNo, birth);
		this.major = major;
		this.year = year;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(">전공: " + major);
		System.out.println(">학번: " + year);
	}

}
