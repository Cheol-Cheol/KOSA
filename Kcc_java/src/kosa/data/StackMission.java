package kosa.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackMission {

	public static void main(String[] args) throws IOException {
		// 키보드로부터 수학수식을 입력
		// ((2+3)+10) => 괄호 일치/불일치 판단
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> stack = new Stack();
		String ipt = br.readLine();

		try {
			for (int i = 0; i < ipt.length(); i++) {
				char ch = ipt.charAt(i);

				if (ch == '(') {
					stack.push(ch + "");
				} else if (ch == ')') {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				System.out.println("일치");
			} else {
				System.out.println("불일치");
			}
		} catch (Exception e) {
			System.out.println("불일치");
		}
	}

}
