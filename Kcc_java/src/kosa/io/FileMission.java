package kosa.io;

import java.io.File;

public class FileMission {

	public static void main(String[] args) {
		// 1. 바이트 스트림을 이용하여 이미지 파일을 복사해보자.
//		String source = "C:\\Users\\KOSA\\Desktop\\Java\\cheol.JPG";
//		String dest = "C:\\Users\\KOSA\\Desktop\\Java\\upload\\cheol.JPG";
//		CopyUtil.copyFile(sourceFile, destFile);

		// 2. 디렉토리 복사 구현
//		String source = "C:\\Users\\KOSA\\Desktop\\Java\\upload";
		String source = "C:\\Users\\KOSA\\Desktop\\Java\\work\\java_work\\KOSA\\Kcc_java";
		String dest = "C:\\Users\\KOSA\\Desktop\\Java\\home";

		File sourceFile = new File(source);
		File destFile = new File(dest);
		CopyUtil.copyDirectory(sourceFile, destFile);

	}

}
