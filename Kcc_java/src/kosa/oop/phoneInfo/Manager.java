package kosa.oop.phoneInfo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Manager {
	// private PhoneInfo[] arr;
	private List<PhoneInfo> list;
	// private Scanner sc;
	private int count;

	public Manager() {
		list = new LinkedList();
		// sc = new Scanner(System.in);
	}

	public void addPhoneInfo() {
		Scanner sc = DataInput.getInstance();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("전화번호: ");
		String phoneNo = sc.next();
		System.out.print("생년월일: ");
		String birth = sc.next();

		// arr[count++] = new PhoneInfo(name, phoneNo, birth);
		list.add(new PhoneInfo(name, phoneNo, birth));
	}

	public void listPhoneInfo() {
		// for (int i = 0; i < count; i++) {
		// arr[i].show();
		// }
		list.iterator().forEachRemaining(PhoneInfo::show);
	}
}
