package kosa.subject.stream.problem.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

	/**
	 * 주어진 정수 리스트에서 중복된 값을 제거하고 유일한 값들만 포함하는 리스트를 반환합니다.
	 *
	 * @param numbers 원본 정수 리스트
	 * @return 중복 없는 정수 리스트
	 */
	public static void main(String[] args) {
		System.out.println(removeDuplicates(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 6, 6)));
	}

	public static List<Integer> removeDuplicates(List<Integer> numbers) {
		return numbers.stream().distinct().collect(Collectors.toList());
	}

}