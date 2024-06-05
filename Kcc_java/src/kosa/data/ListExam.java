package kosa.data;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ListExam {

	public static void main(String[] args) {

		// 1~45 중복되지 않는 로또 번호 6개 출력
		Random r = new Random();
		// 1. 배열로 구현
//		int[] result = new int[6];
//
//		for (int i = 0; i < result.length; i++) {
//			result[i] = r.nextInt(45) + 1;
//			for (int j = 0; j < i; j++) {
//				if (result[i] == result[j]) {
//					i = i - 1;
//				}
//			}
//		}
//
//		Arrays.parallelSort(result);
//		for (int i : result) {
//			System.out.print(i + " ");
//		}

		// 2. 리스트 구현
//		List<Integer> list = new ArrayList();
//
//		while (true) {
//			int n = r.nextInt(45) + 1;
//			if (list.contains(n)) {
//				continue;
//			}
//
//			list.add(n);
//
//			if (list.size() == 6) {
//				break;
//			}
//		}
//
//		Collections.sort(list);
//		for (Integer el : list) {
//			System.out.print(el + " ");
//		}

		// 3. Set 구현 (TreeSet) ==> 중복 허용X, 오름차순 정렬
		Set<Integer> set = new TreeSet();

		for (int i = 0; set.size() < 6; i++) {
			set.add(r.nextInt(45) + 1);
		}

		System.out.println(set);

	}

}
