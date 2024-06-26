package kosa.thread;

public class MultithreadExample3 {

	public static void main(String[] args) {
		SharedArea area = new SharedArea();
		area.account1 = new Account("111-111-1111", "이몽룡", 20000000);
		area.account2 = new Account("222-222-2222", "성춘향", 10000000);

		TransferThread thread1 = new TransferThread(area); // 입금&출금
		PrintThread thread2 = new PrintThread(area);

		thread1.start();
		thread2.start();
		
	}

}
