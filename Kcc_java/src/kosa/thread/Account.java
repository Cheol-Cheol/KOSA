package kosa.thread;

public class Account {
	// 계좌객체 생성하기 위해
	// 만들고자 하는 객체로부터 공통된 데이터 구조와 기능을 추출
	// 상태(데이터) : 계좌번호, 예금주, 잔액 => 멤버변수
	// 행동(기능) : 입금하기, 출금하기 => 멤버메서드

	private String accountNo; // 계좌번호
	private String owner; // 예금주
	private int balance; // 잔액

	public Account() {
	}

	public Account(String accountNo, String owner, int balance) {
		this.accountNo = accountNo;
		this.owner = owner;
		this.balance = balance;
	}

	// 입금하기x
	public void deposit(int amount) {
		balance += amount;
	}

	// 출금하기
	public int withdraw(int amount) throws Exception {
		if (balance < amount) {
			throw new Exception("출금불가");
		}
		balance -= amount;

		return amount;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getOwner() {
		return owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
