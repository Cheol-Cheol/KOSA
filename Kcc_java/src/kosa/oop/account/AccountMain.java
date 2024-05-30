package kosa.oop.account;

public class AccountMain {

	public static void main(String[] args) {
		Account account = new Account(); // ������(Ŭ���� Ÿ��), ��ü ����(�޸� �Ҵ�)

		account.accountNo = "111-111";
		account.owner = "ȫ�浿";
		account.balance = 10000;

		account.deposit(5000);
		try {
			account.withdraw(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("���¹�ȣ: " + account.accountNo);
		System.out.println("������: " + account.owner);
		System.out.println("�ܾ�: " + account.balance);
	}

}
