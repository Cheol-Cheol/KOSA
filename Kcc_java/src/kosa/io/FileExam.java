package kosa.io;

import java.io.File;

public class FileExam {

	public static void main(String[] args) {

		String path = "C:\\Users\\KOSA\\Desktop\\Java\\work\\java_work\\KOSA\\Kcc_java";
		File f = new File(path);
		show(f);

//		File[] files = f.listFiles();
//		for (int i = 0; i < files.length; i++) {
//			recursive(path, files[i].getName());
//		}

	}

	public static void show(File file) {
		File[] list = file.listFiles();

		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				System.out.println();
				System.out.println("** " + list[i].getName() + " **");
				show(list[i]);
			} else {
				System.out.println("\t - " + list[i].getName());
			}
		}
	}

	public static void recursive(String path, String next) {
		String newPath = path + "\\" + next;
		File file = new File(newPath);

		if (file.isDirectory()) {
			System.out.println("** " + file.getName());
			File[] list = file.listFiles();

			for (int i = 0; i < list.length; i++) {

				if (list[i].isDirectory()) {
					recursive(newPath, list[i].getName());
				} else {
					System.out.println("\t- " + list[i].getName());
				}

			}
		}
	}
}
