package kosa.thread;

public class SumMain {

	public static void main(String[] args) throws InterruptedException {
		// t1: 1~50 합을 구하는 스레드
		// t2: 51~100 합을 구하는 스레드
		// main: t1합 + t2합 => 합:5050 => join()

		Thread t1 = new SumThread(1, 50);
		Thread t2 = new SumThread(51, 100);

		t1.start();
		t1.join();

		t2.start();
		t2.join();

		System.out.println(((SumThread) t1).getSum() + ((SumThread) t2).getSum());
	}

}
