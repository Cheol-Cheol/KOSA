package kosa.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineEx {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student("홍길동", 10), new Student("박길동", 20), new Student("김길동", 30));

		double avg = list.stream().mapToInt(student -> student.getScore()).average().getAsDouble();
		System.out.println("평균 점수: " + avg);

		list.stream().map(Student::getName).forEach(System.out::println);

		list.stream().filter(s -> s.getName().startsWith("홍")).forEach(s -> System.out.println(s.getName()));

	}
}
