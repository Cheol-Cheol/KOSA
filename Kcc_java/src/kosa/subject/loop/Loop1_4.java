package kosa.subject.loop;

import java.util.Scanner;

public class Loop1_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number = ");
		int number = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}
