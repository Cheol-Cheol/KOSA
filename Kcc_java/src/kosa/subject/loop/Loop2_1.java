package kosa.subject.loop;

import java.util.Scanner;

public class Loop2_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number = ");
		int number = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
