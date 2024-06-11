package kosa.oop.phoneInfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Manager {
	private List<PhoneInfo> list;
	private int count;

	private static final String FILE_NAME = "phoneInfoDB.txt";

	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public Manager() {
		list = new LinkedList();
	}

	public void addPhoneInfo() {
		Scanner sc = DataInput.getInstance();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("전화번호: ");
		String phoneNo = sc.next();
		System.out.print("생년월일: ");
		String birth = sc.next();

		list.add(new PhoneInfo(name, phoneNo, birth));
	}

	public void listPhoneInfo() {
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

	public void insertData() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			oos.writeObject(list);
			list.clear();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void getData() {
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			list = (List) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
