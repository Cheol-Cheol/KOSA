package kosa.subject.stream.problem.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {

	/**
	 * 주어진 정수 리스트의 각 요소를 제곱하여 새로운 리스트를 반환합니다.
	 *
	 * @param numbers 원본 정수 리스트
	 * @return 각 요소를 제곱한 새 리스트
	 */
	public static void main(String[] args) {
		System.out.println(squareNumbers(Arrays.asList(1, 2, 3, 4, 5)));
	}

	public static List<Integer> squareNumbers(List<Integer> numbers) {
		return numbers.stream().map(n -> n * n).collect(Collectors.toList());
	}

}