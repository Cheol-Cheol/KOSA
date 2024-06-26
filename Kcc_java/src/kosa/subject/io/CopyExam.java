package kosa.subject.io;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyExam {

	public static void main(String[] args) {

		// poem2.txt => poem3.txt: 복사를 구현해보자.
		FileReader reader = null;
		FileWriter writer = null;
		String str = "";

		try {
			reader = new FileReader("poem2.txt");
			writer = new FileWriter("poem3.txt");

			while (true) {
				int data = reader.read();

				if (data == -1) {
					break;
				}

				writer.write((char) data);
			}

			writer.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
