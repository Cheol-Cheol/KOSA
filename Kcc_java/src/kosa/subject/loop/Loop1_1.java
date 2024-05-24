package kosa.subject.loop;

import java.util.Scanner;

public class Loop1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number = ");
		int number = Integer.parseInt(sc.nextLine());

		int val = 1;
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= number; j++) {
				System.out.print(val + " ");
				val++;
			}
			System.out.println();
		}

	}

}
