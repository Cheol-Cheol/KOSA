package kosa.subject.loop;

import java.util.Scanner;

public class Loop1_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number = ");
		int number = Integer.parseInt(sc.nextLine());

		int val = 1;
		for (int i = number; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(val + " ");
				val++;
			}
			System.out.println();
		}
	}

}
