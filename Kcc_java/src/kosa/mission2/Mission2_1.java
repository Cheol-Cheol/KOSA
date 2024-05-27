package kosa.mission2;

import java.util.Scanner;

// 자신의 앞 수 보다 큰 수 출력

// 입력 
// 6
// 7 3 9 5 6 12 

// 출력
// 7 9 6 12
public class Mission2_1 {

	public static void solution(int[] num) {
		System.out.print(num[0] + ", ");
		for (int i = 1; i < num.length; i++) {
			if (num[i] > num[i - 1]) {
				System.out.print(num[i]);

				if (i != num.length - 1) {
					System.out.print(", ");
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] num = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(sc.next());
		}

		solution(num);
//		System.arraycopy(원본배열, 몇번째부터, 복사배열, 몇번째부터, 길이);
	}

}
