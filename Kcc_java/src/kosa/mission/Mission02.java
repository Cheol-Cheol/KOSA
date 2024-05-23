package kosa.mission;

import java.util.Scanner;

public class Mission02 {

	public static final int SUB_CNT = 3;

	public static void main(String[] args) {
		// 성적관리 구현
		// 국,영,수 점수를 입력 받고 총점과 평균(실수형)을 출력하기
		Scanner sc = new Scanner(System.in);
		int korScore = Integer.parseInt(sc.nextLine());
		int engScore = Integer.parseInt(sc.nextLine());
		int mathScore = Integer.parseInt(sc.nextLine());

		int sum = korScore + engScore + mathScore;
		double avg = (double) sum / SUB_CNT;

		System.out.println("총점: " + sum + " 평균: " + avg);
	}

}
