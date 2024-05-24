package kosa.basic;

import java.util.Scanner;

public class ArrayExam01 {

	public static void main(String[] args) {
//		// 1. 배열 선언, 생성 분리
//		int arr[]; // 배열 선언
//		arr = new int[5]; // 배열 생성(메모리 할당)
//
//		// 2. 배열 선언, 생성 함께
//		int arr2[] = new int[5];
//		arr2[0] = 10;
//		arr2[1] = 20;
//
//		// 3. 배열선언, 생성, 초기화 함께
//		int arr3[] = { 1, 2, 3, 4, 5 };
//
//		// 배열에 있는 내용 전체 출력 for
//		for (int i = 0; i < arr3.length; i++) {
//			System.out.println("arr3[" + i + "]=" + arr3[i]);
//		}
//
//		// 향상된 for문
//		for (int n : arr3) {
//			System.out.print(n + ", ");
//		}

		// 배열 사용 방법
		// 1. 배열에 사용될 데이터 타입을 결정한다.
		// 2. 배열의 크기를 결정한다. => ArrayIndexOfBoundsException 예외 발생
		// 3. 배열 생성 방법 선택 => 1, 2, 3
		// 4. 배열을 어떻게 초기화 => 직접 인덱스 접근, for문, 생성과 초기화
		// 5. 배열의 데이터 어떻게 출력 => for문, 향상된 for문, 인덱스를 통해 직접 접근

		// 퀴즈> 키보드로부터 문자열을 입력 받아 배열에 추가한 후 전체를 출력하자
		Scanner sc = new Scanner(System.in);
		String[] results = new String[100];

		int idx = 0;
		while (true) {
			System.out.print(">입력 : ");
			String ipt = sc.nextLine();

			if (ipt.equals("q")) {
				break;
			}

			results[idx++] = ipt;
		}

		System.out.print(">출력: ");
		for (int i = 0; i < idx; i++) {
			if (i == idx - 1) {
				System.out.print(results[i]);
			} else {
				System.out.print(results[i] + ", ");
			}
		}
	}
}
