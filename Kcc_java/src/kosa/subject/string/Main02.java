package kosa.subject.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(solution(str));
	}

	public static String solution(String str) {
		String[] strArr = str.split(" ");
		String result = "";

		for (String s : strArr) {
			if (s.length() > result.length()) {
				result = s;
			}
		}
		return result;
	}
}
