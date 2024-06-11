package kosa.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyUtil {

	// 디렉토리 복사(해당 폴더 복사해서 새로운 디렉토리를 생성 후 모든 파일을 복사)
	public static void copyDirectory(File source, File dest) {
		if (source.isDirectory()) {
			dest.mkdirs();

			File[] fileList = source.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				File sourceFile = fileList[i]; // dir1

				if (sourceFile.isDirectory()) {
					// new File(디렉토리 경로, 파일이름);
					copyDirectory(sourceFile, new File(dest, sourceFile.getName()));
				} else {
					copyFile(sourceFile, new File(dest, sourceFile.getName()));
				}
			}
		}
	}

	// 바이트 값을 가진 파일 1개를 복사하는 메서드
	public static void copyFile(File source, File dest) {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		int data;
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(dest);

			fos.write(fis.readAllBytes());
//			while ((data = fis.read()) != -1) {
//				fos.write((byte) data);
//			}
//			fos.write(arr, 0, data);
			System.out.println("복사완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
