package kosa.subject.io.dos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Dos {

	private File file;

	public Dos() {
		this.file = new File("C:\\Users\\KOSA\\Desktop");
	}

	// ls - 파일 목록 출력
	public void printList() {
		File[] files = file.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
		}
	}

	// cd kosa - 자식 디렉토리 이동
	public void changeDirectory(String dir) {
		if (dir.equals("..")) {
			String[] pathArr = file.getPath().split("\\\\");
			String newPath = "";

			for (int i = 0; i < pathArr.length - 1; i++) {
				newPath += (pathArr[i] + "\\\\");
			}
			setFile(new File(newPath));
		} else {
			setFile(new File(file.getPath(), dir));
		}
	}

	// mkdir kosa - 새로운 디렉토리 생성
	public void makeDirectory(String dir) {
		new File(file.getPath(), dir).mkdirs();
	}

	// vi abc.txt (q => 파일저장)
	public void visualEditor(String fileName) {
		BufferedReader br2 = null;
		BufferedWriter bw = null;
		String str = "";
		Scanner sc = null;
		try {
//			br2 = new BufferedReader(new InputStreamReader(System.in));
			sc = new Scanner(System.in);
			bw = new BufferedWriter(new FileWriter(file.getPath() + "\\\\" + fileName));

			while (true) {
				System.out.print(">");
				str = sc.nextLine();
//				str = br2.readLine();

				if (str.trim().matches("^[q]$")) {
					break;
				} else {
					str += "\n";
					bw.write(str);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
//				br2.close();
				sc.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
