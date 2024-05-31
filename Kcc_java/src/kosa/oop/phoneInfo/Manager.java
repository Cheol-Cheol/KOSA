package kosa.oop.phoneInfo;

import java.util.Scanner;

public class Manager {
	private PhoneInfo[] arr;
	// private Scanner sc;
	private int count;

	public Manager() {
		arr = new PhoneInfo[10];
		// sc = new Scanner(System.in);
	}

	public void addPhoneInfo() {
		Scanner sc = DataInput.getInstance();
		String name = sc.nextLine();
		String phoneNo = sc.nextLine();
		String birth = sc.nextLine();

		arr[count++] = new PhoneInfo(name, phoneNo, birth);
	}

	public void listPhoneInfo() {
		for (int i = 0; i < count; i++) {
			arr[i].show();
		}
	}
}
