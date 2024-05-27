package kosa.mission;

import java.util.Scanner;

//5
//10 13 10 12 15
//12 39 30 23 11
//11 25 50 53 15
//19 27 29 37 27
//19 13 30 13 19
public class Mission2_3 {

	public static int solution(int n, int[][] board) {
		int answer = 0;
		int sum1 = 0; // 가로
		int sum2 = 0; // 세로

		for (int i = 0; i < n; i++) {
			sum1 = 0;
			sum2 = 0;
			for (int j = 0; j < n; j++) {
				sum1 += board[i][j];
				sum2 += board[j][i];
			}
			answer = Math.max(answer, Math.max(sum1, sum2));
		}

		// 대각선 합
		sum1 = 0;
		sum2 = 0;
		for (int i = 0; i < board.length; i++) {
			sum1 += board[i][i];
			sum2 += board[i][n - 1 - i];
		}
		answer = Math.max(Math.max(sum1, sum2), answer);

		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(sc.next());
			}
		}

		System.out.println(solution(N, board));
	}

}
