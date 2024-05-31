package kosa.oop.account;

public class CheckingAccount extends Account {

	private String cardNo;

	public CheckingAccount() {
	}

	public CheckingAccount(String accountNo, String owner, int balance, String cardNo) {
		super(accountNo, owner, balance);
		this.cardNo = cardNo;
	}

	public int pay(String cardNo, int amount) throws Exception {
		if (!this.cardNo.equals(cardNo) || getBalance() < amount) {
			throw new Exception("결제불능");
		}

		return withdraw(amount);
	}
}
