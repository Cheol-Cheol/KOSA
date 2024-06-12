package kosa.thread;

import java.util.stream.IntStream;

public class SumThread extends Thread {

	private int start;
	private int end;
	private int sum;

	public SumThread() {
	}

	public SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		sum = IntStream.rangeClosed(start, end).reduce(0, (acc, val) -> acc + val);
	}

	public int getSum() {
		return sum;
	}

}
