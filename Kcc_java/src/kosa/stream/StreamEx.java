package kosa.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
	// Java8 스트림
	// - 컬렉션 및 배열의 요소 반복 처리
	// - 내부 반복자이므로 처리속도가 빠르고 병렬 처리에 용이(외부 반복자=Iterator)
	// - 람다식으로 다양한 요소 처리 가능
	// - 중간 처리와 종단 처리를 수행하도록 파이프라인 형성 가능

	static int sum;

	public static void main(String[] args) {

		Set<String> set = new HashSet();
		set.add("홍길동");
		set.add("김길동");
		set.add("박길동");

		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));

		List<Product> list = new ArrayList();
		for (int i = 1; i <= 5; i++) {
			Product product = new Product(i, "상품" + i, "멋진 회사 ", (int) (10000 * Math.random()));
			list.add(product);
		}

		// 객체 스트림 얻기
		Stream<Product> stream2 = list.stream();
		stream2.forEach(p -> System.out.println(p));

		int[] intArr = { 1, 2, 3, 4, 5 };
		Arrays.stream(intArr).forEach(i -> System.out.print(i + ","));
		System.out.println();

		IntStream.rangeClosed(1, 100).forEach(a -> sum += a);
		System.out.println(sum);

		Stream<Integer> boxed = IntStream.range(1, 11).boxed();
		boxed.map(Integer::intValue).forEach(System.out::println);
		System.out.println();

		List<Integer> list2 = IntStream.rangeClosed(1, 10).boxed() // Stream<Integer>
				.collect(Collectors.toList()); // List<Interger>
		list2.stream().forEach(System.out::println);

		// IntStream.of() - 원하는 숫자
		IntStream.of(2, 4, 6, 8, 10).boxed().collect(Collectors.toList());

		// 문자열 배열 => List, Stream 변환
		String[] arr = { "BB", "CC", "AA" };
		List<String> list3 = Arrays.asList(arr);

		Stream<String> stream3 = list3.stream();
		stream3.sorted().forEach(System.out::println);

		list3.stream().sorted(Comparator.reverseOrder());
	}
}
