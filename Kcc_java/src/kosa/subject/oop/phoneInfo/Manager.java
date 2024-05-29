package kosa.subject.oop.phoneInfo;

public class Manager {

	private final PhoneInfo[] phoneInfos;
	private int cnt;

	public Manager() {
		this.phoneInfos = new PhoneInfo[10];
		this.cnt = 0;
	}

	// �߰�
	public void addPhoneInfo(String name, String tel, String birth) {
		phoneInfos[cnt++] = new PhoneInfo(name, tel, birth);
		System.out.println(">��ȭ��ȣ�� ��� �Ǿ����ϴ�. ���� ��� ����: " + cnt + "��");
	}

	// ���
	public void listPhoneInfo() {
		if (cnt == 0) {
			System.out.println(">��ϵ� ��ȭ��ȭ�� �����ϴ�.");
		}

		for (PhoneInfo phoneInfo : phoneInfos) {
			if (phoneInfo != null) {
				phoneInfo.printPhoneInfo();
			}
		}
	}

	// �˻�
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
