package kosa.api;

import java.util.Scanner;

public class RegularExam {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		String str = sc.nextLine();

		// abc 문자를 포함 여부 체크
//		if(str.matches(".*abc.*")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}

		// 숫자만 3자리 유무 판단
//		if (str.matches("[\\d]{3}")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}

		// 알파벳, 숫자만 5자리 이상
//		if (str.matches("[\\w]{5,}")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}

		// 한글 3~5
//		if (str.matches("[가-힣]{3,5}")) {
//			System.out.println("매칭");
//		} else {
//			System.out.println("비매칭");
//		}

		// 이메일 검증
		// dream1752@naver.com => 매칭
		// 423dream1752@naver.com => 비매칭
		// dream1752naver.com => 비매칭
		// dream1752@naver.comcom => 비매칭
//		if (str.matches("^[a-z]+[\\w]+@{1}[a-z]+(.{1}((com)|(co\\.kr)))$")) {
		if (str.matches("^[\\D]\\w+@\\w+\\.\\w{2,3}$")) {
			System.out.println("매칭");
		} else {
			System.out.println("비매칭");
		}
	}

}
