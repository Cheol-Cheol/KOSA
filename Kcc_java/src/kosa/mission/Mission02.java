package kosa.mission;

import java.util.Scanner;

public class Mission02 {

	public static final int SUB_CNT = 3;

	public static void main(String[] args) {
		// �������� ����
		// ��,��,�� ������ �Է� �ް� ������ ���(�Ǽ���)�� ����ϱ�
		Scanner sc = new Scanner(System.in);
		int korScore = Integer.parseInt(sc.nextLine());
		int engScore = Integer.parseInt(sc.nextLine());
		int mathScore = Integer.parseInt(sc.nextLine());

		int sum = korScore + engScore + mathScore;
		double avg = (double) sum / SUB_CNT;

		System.out.println("����: " + sum + " ���: " + avg);
	}

}
