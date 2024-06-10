package kosa.io;

import java.io.FileWriter;
import java.util.Scanner;

public class KosaWriter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FileWriter writer = null;
		String str = "";
		String poem = "";

		while (!(str = sc.nextLine()).equals("q")) {
			poem += str;
			poem += "\n";
		}

		try {
			writer = new FileWriter("poem2.txt");
			writer.write(poem);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				sc.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
