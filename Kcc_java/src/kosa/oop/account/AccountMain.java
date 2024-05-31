package kosa.oop.account;

public class AccountMain {

	public static void main(String[] args) {
		Account account = new Account();

//		account.accountNo = "111-111";
//		account.owner = "홍길동";
//		account.balance = 10000;

		account.deposit(5000);
		try {
			account.withdraw(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println("계좌번호: " + account.accountNo);
//		System.out.println("예금주: " + account.owner);
//		System.out.println("잔액: " + account.balance);
	}

}
