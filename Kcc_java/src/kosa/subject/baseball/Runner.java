package kosa.subject.baseball;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BaseBalls baseBalls = new BaseBalls();
		System.out.println("���� �ٸ� �� �ڸ� ���ڸ� �Է��Ͻÿ�.");

		int cnt = 1;
		while (true) {
			System.out.print("����: ");
			baseBalls.printAnswer();
			System.out.println();
			//
			System.out.print("�Է�> ");
			int iptNum = Integer.parseInt(sc.next());

			// ���� üũ
			String result = baseBalls.checkAnswer(iptNum);
			if (result.equals("3Strike")) {
				System.out.println(cnt + "��° ����");
				break;
			} else {
				cnt++;
				System.out.println("���> " + result);
			}
		}
	}
}
