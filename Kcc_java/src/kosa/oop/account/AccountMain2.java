package kosa.oop.account;

public class AccountMain2 {

	public static void main(String[] args) {

		Account arr[] = { new Account("111-111", "홍길동", 10000),
				new CheckingAccount("111-111", "홍길동2", 20000, "222-222"),
				new MinusAccount("333-333", "김길동", 30000, 20000) };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof CheckingAccount) {
				try {
					((CheckingAccount) arr[i]).pay("222-222", 5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(arr[1].getBalance());

//		Account ca = new CheckingAccount("111-111", "홍길동", 10000, "222-222");

//		// 자식으로 강제 형변환
//		// CheckingAccount ca2 = (CheckingAccount) ca;
//		try {
//			if (ca instanceof CheckingAccount) {
//				((CheckingAccount) ca).pay("222-222", 3000);
//			} else {
//				System.out.println("형변환 불가");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(ca.getBalance());

//		CheckingAccount ca = new CheckingAccount("111-111", "홍길동", 10000, "222-222");
//
//		try {
//			ca.pay("222-222", 3000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(ca.getBalance());
//
//		MinusAccount ma = new MinusAccount("111-111", "황철원", 30000, 50000);
//
//		try {
//			System.out.println(ma.withdraw(25000));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
