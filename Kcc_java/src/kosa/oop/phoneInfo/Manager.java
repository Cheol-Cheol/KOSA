package kosa.oop.phoneInfo;

import java.util.Scanner;

// ��ȭ��ȣ ���� �������� ���
public class Manager {
	private PhoneInfo[] arr;
	private Scanner sc;
	private int count;

	public Manager() {
		arr = new PhoneInfo[10];
		sc = new Scanner(System.in);
		count = 0;
	}

	public void addPhoneInfo() {
		// Ű����κ��� �̸�, ��ȭ, ��������� �Է� �޾�
		// PhoneInfo ��ü�� �����ؼ� �迭�� �߰��ϴ� ��
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String phoneNo = sc.nextLine();
		System.out.print("�������: ");
		String birth = sc.nextLine();

		arr[count++] = new PhoneInfo(name, phoneNo, birth);
	}

	public void listPhoneInfo() {
		for (int i = 0; i < count; i++) {
			arr[i].show();
		}
	}
}
