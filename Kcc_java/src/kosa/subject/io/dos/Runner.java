package kosa.subject.io.dos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Dos dos = new Dos();

		System.out.println("Microsoft Windows [Version 10.0.19045.4412]\r\n"
				+ "(c) Microsoft Corporation. All rights reserved.\n");

		while (true) {
			System.out.print(dos.getFile().getPath() + ">");
			String[] iptArr = br.readLine().trim().split(" ");

			switch (iptArr[0]) {
			case "ls":
				dos.printList();
				break;
			case "cd":
				dos.changeDirectory(iptArr[1]);
				break;
			case "mkdir":
				dos.makeDirectory(iptArr[1]);
				break;
			case "vi":
				dos.visualEditor(iptArr[1]);
				break;
			case "exit":
				System.out.println("DOS 종료");
				return;
			default:
				System.out.println(iptArr[0] + "은(는) 내부 또는 외부 명령, 실행할 수 있는 프로그램, 또는\r\n" + "배치 파일이 아닙니다.\n");
			}
		}

	}

}
