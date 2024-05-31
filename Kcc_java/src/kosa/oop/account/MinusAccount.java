package kosa.oop.account;

public class MinusAccount extends Account {

	private int creditLine; // 마이너스 한도

	public MinusAccount() {
	}

	public MinusAccount(String accountNo, String owner, int balance, int creditLine) {
		super(accountNo, owner, balance);
		this.creditLine = creditLine;
	}

	// 오버라이딩
	// 1. 상속 관계
	// 2. 메서드의 시그니처(접근 제어자, 리턴형, 메서드명, 메서드 파라미터) 일치
	// 3. 메서드의 내용 불일치(재정의)

	@Override
	public int withdraw(int amount) throws Exception {
		if (getBalance() + creditLine < amount) {
			throw new Exception("잔액부족");
		}

		int balance = getBalance();
		setBalance(balance - amount);

		return amount;
	}

}
