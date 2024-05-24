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

		// 학점 90이상 -> A학점
		// 80이상 -> B학점
		// 70이상 -> C학점
		// 60이상 -> D학점
		// 50이상 -> F학점
		char grade;
		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		
		System.out.println("학점: " + grade);
	}

}
