package kosa.subject.stream.problem.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

public class Problem4 {

	/**
	 * 주어진 정수 리스트에서 최대값을 반환합니다. 최소값을 찾는 것도 비슷한 방법으로 할 수 있습니다.
	 *
	 * @param numbers 원본 정수 리스트
	 * @return 리스트의 최대값
	 */
	public static void main(String[] args) {
		System.out.println(findMax(Arrays.asList(1, 2, 3, 4, 5)).getAsInt());
	}

	public static OptionalInt findMax(List<Integer> numbers) {
		return OptionalInt.of(Collections.max(numbers));
		// numbers.stream().mapToInt(n -> n).max();
		// numbers.stream().max(Integer::compareTo); - Optional<Integer>
	}

}