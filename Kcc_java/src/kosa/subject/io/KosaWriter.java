package kosa.subject.io;

import java.io.FileWriter;
import java.util.Scanner;

public class KosaWriter {

	public static void main(String[] args) {

		// 키보드로부터 문자열을 입력 받아 파일에 쓰는 예제를 구현하자.
		// "q"를 입력하기 전까지 문자열을 파일에 쓰기
		// FileWrtier: write(문자열)
		// 파일명: poem2.txt : 미리 생성X
		// 코드 실행 후 리플래쉬 => 파일 생성 확인 O
		// close() 구현

		FileWriter writer = null;
		Scanner sc = null;
		String ipt = "";

		try {
			writer = new FileWriter("poem2.txt");
			sc = new Scanner(System.in);

			while (true) {
				System.out.print("입력>");
				ipt = sc.nextLine();

				if (ipt.equals("q")) {
					System.out.println("입력 종료");
					break;
				}

				writer.write(ipt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				writer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
