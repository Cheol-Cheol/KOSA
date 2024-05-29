package kosa.subject.oop.phoneInfo;

public class Manager {

	private final PhoneInfo[] phoneInfos;
	private int cnt;

	public Manager() {
		this.phoneInfos = new PhoneInfo[10];
		this.cnt = 0;
	}

	// 추가
	public void addPhoneInfo(String name, String tel, String birth) {
		phoneInfos[cnt++] = new PhoneInfo(name, tel, birth);
		System.out.println(">전화번호가 등록 되었습니다. 현재 등록 개수: " + cnt + "개");
	}

	// 출력
	public void listPhoneInfo() {
		if (cnt == 0) {
			System.out.println(">등록된 전화번화가 없습니다.");
		}

		for (PhoneInfo phoneInfo : phoneInfos) {
			if (phoneInfo != null) {
				phoneInfo.printPhoneInfo();
			}
		}
	}

	// 검색
	public PhoneInfo searchPhoneInfo(String name) throws NullPointerException {
		PhoneInfo target = null;

		for (PhoneInfo phoneInfo : phoneInfos) {
			if (phoneInfo == null) {
				throw new NullPointerException("전화번호를 찾지 못했습니다.");
			}
			if (phoneInfo.getName().equals(name)) {
				target = phoneInfo;
				break;
			}
		}

		return target;
	}

}
