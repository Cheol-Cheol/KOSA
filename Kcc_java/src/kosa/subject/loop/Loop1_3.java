package kosa.subject.loop;

import java.util.Scanner;

public class Loop1_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number = ");
		int number = Integer.parseInt(sc.nextLine());

		int cnt = 1;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print(cnt + " ");
				cnt += 2;
			}
			System.out.println();
		}
	}

}
