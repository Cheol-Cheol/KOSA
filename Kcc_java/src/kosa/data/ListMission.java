package kosa.data;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListMission {

	public static void main(String[] args) throws IOException {

		// List 자료구조를 활용하여 키보로부터 문자열을 입력받아 처리하자.
		// 1. 데이터 추가 2. 데이터 삭제 3. 데이터 출력(for, Iterator) 4. 종료
		Scanner sc = new Scanner(System.in);
		List<String> list = new LinkedList();
		int cmd;

		while (true) {
			System.out.println("1. 데이터 추가 | 2. 데이터 삭제 | 3. 데이터 출력 | 4. 종료");
			System.out.print(">");
			cmd = Integer.parseInt(sc.next());

			switch (cmd) {
			case 1:
				System.out.print("문자열 입력>");
				list.add(sc.next());
				break;
			case 2:
				System.out.print("삭제할 문자열 입력>");
				int idx = list.indexOf(sc.next());
				if (idx != -1) {
					list.remove(idx);
				} else {
					System.out.println("존재하지 않습니다.");
				}
				break;
			case 3:
				// getAllListByFor(list);
				getAllListByIterator(list);
				break;
			case 4:
				System.out.println("서비스 종료");
				sc.close();
				return;
			}
		}
	}

	private static void getAllListByFor(List<String> list) {
		for (String el : list) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	private static void getAllListByIterator(List<String> list) {
		list.iterator().forEachRemaining((el) -> System.out.print(el + " "));
		System.out.println();
	}

}
