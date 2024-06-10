package kosa.stream;

import java.util.ArrayList;
import java.util.List;

public class SortingEx {

	public static void main(String[] args) {

		List<Student> list = new ArrayList();
		list.add(new Student("홍길동", 30));
		list.add(new Student("박길동", 20));
		list.add(new Student("김길동", 10));

		list.stream().sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()));
	}

}
