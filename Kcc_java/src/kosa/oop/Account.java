package kosa.oop;

public class Account {
	// 계좌객체 생성 하기위해
	// 객체로부터 공통된 데이터 구조와 기능을 추출
	// 상태(데이터) : 계좌번호, 계좌주, 잔액 => 멤버 변수
	// 행동(기능) : 입금하다, 출금하다 => 멤버 메서드

	String accountNo; // 계좌번호
	String owner; // 계좌주
	int balance; // 잔액

	// 입금하다.
	public void deposit(int amount) {
		balance += amount;
	}
	
	// 출금하다.
	public int withdraw(int amount) throws Exception {
		if (balance < amount) {
			throw new Exception("잔액 부족");
		}
		balance -= amount;

		return amount;
	}

}
