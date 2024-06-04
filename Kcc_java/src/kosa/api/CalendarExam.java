package kosa.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarExam {

	public static void main(String[] args) {
		// GregorianCalendar gc = new GregorianCalendar();
		Calendar gc = Calendar.getInstance();
		// System.out.println(gc);

		String now = gc.get(Calendar.YEAR) + "년 " + (gc.get(Calendar.MONTH) + 1) + "월 " + gc.get(Calendar.DATE) + "일 "
				+ gc.get(Calendar.HOUR) + "시 " + gc.get(Calendar.MINUTE) + "분 ";

		System.out.println("현재시간: " + now);

		gc.add(Calendar.DATE, 100);

		String future = gc.get(Calendar.YEAR) + "년 " + (gc.get(Calendar.MONTH) + 1) + "월 " + gc.get(Calendar.DATE)
				+ "일 " + gc.get(Calendar.HOUR) + "시 " + gc.get(Calendar.MINUTE) + "분 ";

		System.out.println("100일 후: " + future);

		gc.set(2022, 5, 4);
		gc.add(Calendar.DATE, 1000);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(sdf.format(gc.getTime()));

		// 퀴즈: 2024년 ~ 2030년까지 자신의 생일이 무슨 요일?
		gc = gc.getInstance();

		char[] week = { '일', '월', '화', '수', '목', '금', '토' };
		for (int i = 2024; i <= 2030; i++) {
			gc.set(i, 8, 3);
			System.out.println(i + "년: " + week[gc.get(Calendar.DAY_OF_WEEK) - 1] + "요일");
		}

	}

}
