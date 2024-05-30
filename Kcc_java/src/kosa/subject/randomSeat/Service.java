package kosa.subject.randomSeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

	private static List<String> studentNames = new ArrayList<>(
			Arrays.asList("김상학", "김연호", "김영진", "김진아", "김현민", "노승우", "도성구", "송동호", "송예림", "안수형", "우영두", "원승언", "유은서",
					"유재원", "윤채원", "이수호", "이예림", "이주언", "이지훈", "이한희", "장원", "조정하", "지승용", "황철원"));

	private List<Seat> randSeats;

	public Service() {
		randSeats = new ArrayList<Seat>();
	}

	public void createRandSeat() {
		//
		while (true) {
			int randNum = (int) (Math.random() * 24); // 0 ~ 23
			String studentName = studentNames.get(randNum);

			if (!randSeats.contains(studentName)) { // 포함되어있지 않다면?
				// new Seat()
			}

			if (randSeats.size() == 24) {
				break;
			}
		}

		System.out.println("학생들의 랜덤 좌석 배치가 완료되었습니다.");
	}

	// 배정된 좌석 출력(학생이름)
	public void printResult() {
		// randSeats 출력
	}
}
