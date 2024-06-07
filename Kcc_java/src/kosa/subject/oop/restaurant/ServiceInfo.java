package kosa.subject.oop.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceInfo {

	private BufferedReader br;

	public ServiceInfo() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public int printCommand() throws IOException {
		System.out.println("1.주문요청 | 2.주문처리 | 3.매출액 총액 | 4.종료");
		System.out.print(">");
		return Integer.parseInt(br.readLine());
	}

	public String inputString(String name) throws IOException {
		System.out.print(name + ": ");
		return br.readLine();
	}

	public int inputInt(String name) throws IOException {
		System.out.print(name + ": ");
		return Integer.parseInt(br.readLine());
	}

	public void printError(Exception e) {
		System.out.println("[서비스 알림] " + e.getMessage());
	}

	public void printExit() {
		System.out.println("서비스 종료");
	}

	public void printInvalid() {
		System.out.println("1~4번중에 골라주세요.");
	}
}
