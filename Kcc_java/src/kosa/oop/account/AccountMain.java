package kosa.oop.account;

public class AccountMain {

	public static void main(String[] args) {
		Account account = new Account(); // 참조형(클래스 타입), 객체 생성(메모리 할당)

		account.accountNo = "111-111";
		account.owner = "홍길동";
		account.balance = 10000;

		account.deposit(5000);
		try {
			account.withdraw(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("계좌번호: " + account.accountNo);
		System.out.println("계좌주: " + account.owner);
		System.out.println("잔액: " + account.balance);
	}

}
