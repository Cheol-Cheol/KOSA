package kosa.subject.oop.phoneInfo;

public class PhoneInfo {
	private String name;
	private String phoneNo;
	private String birth;

	public PhoneInfo(String name, String phoneNo, String birth) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getBirth() {
		return birth;
	}

	public void printPhoneInfo() {
		System.out.println();
		System.out.println("======================");
		System.out.println(">�̸�: " + name);
		System.out.println(">��ȭ��ȣ: " + phoneNo);
		System.out.println(">�������: " + birth);
		System.out.println("======================");
	}

}
