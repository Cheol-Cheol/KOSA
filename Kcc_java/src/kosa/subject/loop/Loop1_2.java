package kosa.subject.loop;

import java.util.Scanner;

public class Loop1_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number = ");
		int number = Integer.parseInt(sc.nextLine());

		for (int i = number - 1; i >= 0; i--) {
			int val = (number * i) + 1;
			for (int j = 1; j <= number; j++) {
				System.out.print(val + " ");
				val++;
			}
			System.out.println();
		}
	}

}
