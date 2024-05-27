package kosa.mission;

import java.util.Scanner;

public class Galaga {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int num = 0;

		for (int i = 1; i <= T; i++) {
			int A = Integer.parseInt(sc.next());
			int B = Integer.parseInt(sc.next());
			int cnt = 0;

			while (true) {
				cnt++;

				A *= 2;
				B *= 3;

				if (A <= B) {
					System.out.println("#" + i + " " + cnt);
					break;
				}
			}
		}
	}

}
