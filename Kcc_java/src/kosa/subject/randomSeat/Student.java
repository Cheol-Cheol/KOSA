package kosa.subject.randomSeat;

public class Student {

	private static int num = 0;

	private int studentId;
	private String name;
	private int age;
	private String addr;
	private String tel;

	public Student() {
	}

	public Student(String name, int age, String addr, String tel) {
		num++;
		studentId = num;

		this.name = name;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddr() {
		return addr;
	}

	public String getTel() {
		return tel;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void printStudentInfo() {
		
	}
}
