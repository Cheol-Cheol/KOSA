package kosa.api;

import java.util.Arrays;

public class StringExam {

	public static void main(String[] args) {

		// 1. String 객체 생성 방법과 차이점
		String str = "ABC";
		String str2 = "ABC";
		String str3 = new String("ABC");

		if (str == str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		// 2. String 클래스 불번성 특징
		str = str.concat("DEF");
		System.out.println(str);

		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		System.out.println(sb);

		// 연산자(+) 변경 가능
		String sql = "SELECT * FROM board ";
		int num = 10;

		if (num == 10) {
			sql += "WHERE num = 10 ";
		}

		System.out.println(sql);

		// 해당 문자열의 위치를 파악 => indexOf("문자열") => 해당 문자열의 인덱스, 없으면 -1
		System.out.println(sql.indexOf("board"));

		System.out.println(sql.length());

		for (int i = 0; i < sql.length(); i++) {
			System.out.print(sql.charAt(i));
		}
		System.out.println();

		// 문자열 부분 추출: subString(5), subString(5, 10)
		// 퀴즈: sql 변수 "board" 문자열만 출력
		String target = "board";
		int pos = sql.indexOf(target);
		System.out.println(sql.substring(pos, pos + target.length()));

		// 퀴즈
		String fileName = "kosa.jpg";
		String[] strArr = fileName.split("\\.");
		System.out.println("head: " + strArr[0] + "| pattern: " + strArr[1]);

		String id = "kosa";
		String m_id = "Kosa";

		// 대소문자 구분X
		if (id.equalsIgnoreCase(m_id.trim())) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		// 문자열 -> String[] 변환
		String fruits = "사과,포도,수박,배";
		String[] arr = fruits.split(",");
		System.out.println(Arrays.toString(arr));

		// 문자열 -> char[] 변환
		String str5 = "abcdef";
		char[] arr2 = str5.toCharArray();
		System.out.println(Arrays.toString(arr2));

		// 문자열 -> byte[] 변환
		String str6 = "abcdef";
		byte[] arr3 = str6.getBytes();
		System.out.println(Arrays.toString(arr3)); // [97, 98, 99, 100, 101, 102]

		// 문자열 -> 정수형
		String str7 = "100";
		int num2 = Integer.parseInt(str7);
		System.out.println(num2);

		int num3 = 10;
		// String str8 = String.valueOf(num3);
		String str8 = 10 + "";
		System.out.println(str8);

	}

}
