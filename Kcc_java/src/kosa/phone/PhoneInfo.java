package kosa.phone;

public class PhoneInfo {

	private String name;
	private String phoneNo;
	private String birth;

	public PhoneInfo() {
	}

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

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void show() {
		System.out.println("�̸�: " + name);
		System.out.println("��ȭ��ȣ: " + phoneNo);
		System.out.println("�������: " + birth);
	}
	
}