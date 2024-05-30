package kosa.subject.baseball;

public class BaseBalls {

	private int[] randomArr;
	private int[] testArr;

	public BaseBalls() {
		randomArr = new int[3];
		testArr = new int[3];
		makeRandom();
	}

	// 서로 다른 랜덤 3자리 생성
	private void makeRandom() {
		// 첫 번째 값 설정
		randomArr[0] = (int) (Math.random() * 9) + 1;

		int idx = 1;
		while (true) {
			int randNum = (int) (Math.random() * 9) + 1;

			// 중복 체크
			if (isDuplicate(randNum)) {
				continue;
			} else {
				randomArr[idx++] = randNum;
				if (idx == 3) {
					break;
				}
			}
		}
	}

	// 중복 체크
	private boolean isDuplicate(int num) {
		boolean result = false;

		for (int i = 0; i < randomArr.length; i++) {
			if (randomArr[i] == num) {
				result = true;
				break;
			}
		}

		return result;
	}

	// 입력 배열 설정
	public void createTestArr(int iptNum) {
		String iptNumStr = String.valueOf(iptNum);

		for (int i = 0; i < iptNumStr.length(); i++) {
			testArr[i] = iptNumStr.charAt(i) - '0';
		}
	}

	// 유효성 검사
	public boolean checkAnswer(int iptNum) {
		createTestArr(iptNum);

		// 숫자 비교
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < 3; i++) {
			int tmp = testArr[i];

			// 스트라이크 검사
			for (int j = 0; j < 3; j++) {
				if (tmp == randomArr[j]) {
					if (i == j) {
						strike++;
					}

					if (i != j) {
						ball++;
					}
				}
			}
		}

		if (strike == 3) {
			System.out.println("3Strike");
			return true;
		} else {
			System.out.println(strike + "S" + ball + "B");
			return false;
		}
	}

	// 정답 출력
	public void printAnswer() {
		for (int i = 0; i < randomArr.length; i++) {
			System.out.print(randomArr[i]);
		}
	}
}
