package kosa.subject.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		System.out.println(solution(str));
	}

	private static int solution(String str) {
		char[] strArr = str.toCharArray();
		String result = "";

		for (int i = 0; i < strArr.length; i++) {
			if (Character.isDigit(strArr[i])) {
				result += strArr[i];
			}
		}
		return Integer.parseInt(result);
	}

}
