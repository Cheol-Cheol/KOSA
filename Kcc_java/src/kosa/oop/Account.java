package kosa.oop;

public class Account {
	// ���°�ü ���� �ϱ�����
	// ��ü�κ��� ����� ������ ������ ����� ����
	// ����(������) : ���¹�ȣ, ������, �ܾ� => ��� ����
	// �ൿ(���) : �Ա��ϴ�, ����ϴ� => ��� �޼���

	String accountNo; // ���¹�ȣ
	String owner; // ������
	int balance; // �ܾ�

	// �Ա��ϴ�.
	public void deposit(int amount) {
		balance += amount;
	}
	
	// ����ϴ�.
	public int withdraw(int amount) throws Exception {
		if (balance < amount) {
			throw new Exception("�ܾ� ����");
		}
		balance -= amount;

		return amount;
	}

}
