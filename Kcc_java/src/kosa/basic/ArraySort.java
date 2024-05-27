package kosa.basic;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

	public static void main(String[] args) {
		// 배열 내용 정렬
		int[] arr = { 3, 2, 5 };
		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// 내림차순(for문) - 정렬 알고리즘으로 풀어보기
		System.out.print("[");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);

			if (i != 0) {
				System.out.print(", ");
			}
		}
		System.out.print("]\n");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[arr.length - 1 - i] + ", ");
		}
		System.out.println();

		int[][] arr2 = { { 2, 90 }, { 1, 60 }, { 3, 20 } }; // [3][2]
		Arrays.sort(arr2, new ArrayComparator());
		Arrays.sort(arr2, Comparator.comparing(o -> o[0])); // 람다식

		System.out.println(Arrays.deepToString(arr2)); // 2차원 출력
	}

}

// 별도의 구현체로 분리하여 가독성과 재사용성 높이기
class ArrayComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		// 정렬 기준 작성 => 2차원 배열 안에 1차원 첫 번째 인덱스를 기준으로 오름차순
		if (o1[0] < o2[0]) {
			return -1; // 안 바꿔도 된다.
		} else if (o1[0] > o2[0]) {
			return 1; // 바꾼다.
		} else {
			return 0; // 값이 같으니 안 바꿔도 된다.
		}
	}
}
