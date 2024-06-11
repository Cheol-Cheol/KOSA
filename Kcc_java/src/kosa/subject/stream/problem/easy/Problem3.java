package kosa.subject.stream.problem.easy;

import java.util.Arrays;
import java.util.List;

public class Problem3 {

	/**
	 * 주어진 Double 리스트의 모든 요소의 합계를 반환합니다.
	 *
	 * @param numbers 원본 Double 리스트
	 * @return 요소들의 합계
	 */
	public static void main(String[] args) {
		System.out.println(sumOfList(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0)));
	}

	public static double sumOfList(List<Double> numbers) {
		return numbers.stream().mapToDouble(Double::doubleValue).sum();
	}

}