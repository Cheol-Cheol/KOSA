package kosa.subject.oop.phoneInfo;

import java.util.Scanner;

import kosa.oop.phoneInfo.DataInput;

public class Manager {

	private final PhoneInfo[] phoneInfos;
	private int cnt;
	private Scanner sc;

	public Manager() {
		this.phoneInfos = new PhoneInfo[10];
		sc = DataInput.getInstance();
	}

	// 추가
	public void addPhoneInfo() {
		System.out.print("> 이름: ");
		String name = sc.next();
		System.out.print("> 전화번호: ");
		String tel = sc.next();
		System.out.print("> 생년월일: ");
		String birth = sc.next();

		System.out.println("1.일반 2.회사 3.동창");
		System.out.print("> ");
		int type = Integer.parseInt(sc.next());

		switch (type) {
		case 1:
			phoneInfos[cnt++] = new PhoneInfo(name, tel, birth);
			break;
		case 2:
			System.out.print("> 부서: ");
			String dept = sc.next();
			System.out.print("> 직책: ");
			String position = sc.next();

			phoneInfos[cnt++] = new Company(name, tel, birth, dept, position);
			break;
		case 3:
			System.out.print("> 전공: ");
			String major = sc.next();
			System.out.print("> 학번: ");
			String year = sc.next();

			phoneInfos[cnt++] = new Universe(name, tel, birth, major, year);
			break;
		}

		System.out.println("추가완료");
	}

	// 전체 목록 출력
	public void listPhoneInfo() {
		if (cnt == 0) {
			System.out.println("> 목록이 비었습니다.");
		} else {

			System.out.println("1.전체 2.회사 3.동창");
			System.out.print("> ");
			int type = Integer.parseInt(sc.next());

			switch (type) {
			case 1:
				for (int i = 0; i < cnt; i++) {
					phoneInfos[i].printInfo();
				}
				break;
			case 2:
				for (int i = 0; i < cnt; i++) {
					if (phoneInfos[i] instanceof Company) {
						phoneInfos[i].printInfo();
					}
				}
				break;
			case 3:
				for (int i = 0; i < cnt; i++) {
					if (phoneInfos[i] instanceof Universe) {
						phoneInfos[i].printInfo();
					}
				}
				break;
			}

		}
	}

	// 검색
	public PhoneInfo searchPhoneInfo(String name) throws NullPointerException {
		PhoneInfo target = null;

		for (PhoneInfo phoneInfo : phoneInfos) {
			if (phoneInfo == null) {
				throw new NullPointerException("��ȭ��ȣ�� ã�� ���߽��ϴ�.");
			}
			if (phoneInfo.getName().equals(name)) {
				target = phoneInfo;
				break;
			}
		}

		return target;
	}

}
