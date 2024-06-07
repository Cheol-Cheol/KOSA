package kosa.oop.phoneInfo;

import java.util.Collections;
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

	public void sortPhoneInfo() {
		System.out.println("[오름차순] 1. 이름순 | 2. 전화번호순 | 3. 생년월일순");
		System.out.println("[내림차순] 4. 이름순 | 5. 전화번호순 | 6. 생년월일순");
		Scanner sc = DataInput.getInstance();
		int cmd = Integer.parseInt(sc.next());
		switch (cmd) {
		// 오름차순
		case 1:
			Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
			break;
		case 2:
			Collections.sort(list, (o1, o2) -> o1.getPhoneNo().compareTo(o2.getPhoneNo()));
			break;
		case 3:
			Collections.sort(list, (o1, o2) -> o1.getBirth().compareTo(o2.getBirth()));
			break;
		// 내림차순
		case 4:
			Collections.sort(list, (o1, o2) -> o2.getName().compareTo(o1.getName()));
			break;
		case 5:
			Collections.sort(list, (o1, o2) -> o2.getPhoneNo().compareTo(o1.getPhoneNo()));
			break;
		case 6:
			Collections.sort(list, (o1, o2) -> o2.getPhoneNo().compareTo(o1.getPhoneNo()));
			break;
		}
	}
}
