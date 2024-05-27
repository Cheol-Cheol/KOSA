package kosa.mission;

import java.util.Scanner;

public class Mission2_1 {

	public static void main(String[] args) {
		// 국어, 영어, 수학 => 키보드로 입력 받아 배열로 구현하기
		// 총점, 평균 구하기 => 메서드 정의 구현
		Scanner sc = new Scanner(System.in);
		String[] subject = { "국어", "영어", "수학" };
		int[] score = new int[subject.length];
		for (int i = 0; i < score.length; i++) {
			System.out.print(subject[i] + " 점수 입력 >");
			score[i] = Integer.parseInt(sc.nextLine());
		}

		int total = calSum(score);
		String formattedAvg = String.format("%.2f", calAvg(total, score.length));
		
		System.out.println("=============================");
		System.out.println("총점: " + total);
		System.out.println("평균: " + formattedAvg);
		System.out.println("=============================");
	} 

	public static int calSum(int[] score) {
		int sum = 0;
		for (int i : score) {
			sum += i;
		}
		return sum;
	}

	public static double calAvg(int sum, int cnt) {
		return (double) sum / cnt;
	}

}
