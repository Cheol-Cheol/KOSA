package kosa.mission.mission2;

import java.util.Scanner;

// 8
// 130 135 148 140 145 150 150 153
public class Mission2_2 {

	public static int solution(int[] students) {
		int cnt = 1;
		int tmp = students[0];
		for (int i = 1; i < students.length; i++) {
			if(tmp < students[i]) {
				cnt++;
				tmp = students[i];
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] students = new int[N];
		for (int i = 0; i < students.length; i++) {
			students[i] = Integer.parseInt(sc.next());
		}

		System.out.println(solution(students));
	}

}
