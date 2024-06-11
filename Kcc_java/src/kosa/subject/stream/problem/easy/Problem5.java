package kosa.subject.stream.problem.easy;

import java.util.Arrays;
import java.util.List;

public class Problem5 {

	/**
	 * 주어진 문자열 리스트를 하나의 문자열로 연결하여 반환합니다.
	 *
	 * @param strings 원본 문자열 리스트
	 * @return 연결된 문자열
	 */
	public static void main(String[] args) {
		System.out.println(concatenateStrings(Arrays.asList("안", "녕", "하", "세", "요")));
	}

	public static String concatenateStrings(List<String> strings) {
		return strings.stream().reduce("", (acc, val) -> acc + val);
	}
	
}