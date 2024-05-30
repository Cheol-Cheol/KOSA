package kosa.subject.baseball;

public class BaseBalls {

	private int[] randomArr;
	private int[] testArr;

	public BaseBalls() {
		randomArr = new int[3];
		testArr = new int[3];
		makeRandom();
	}

	// ���� �ٸ� ���� 3�ڸ� ����
	private void makeRandom() {
		// ù ��° �� ����
		randomArr[0] = (int) (Math.random() * 9) + 1;

		int idx = 1;
		while (true) {
			int randNum = (int) (Math.random() * 9) + 1;

			// �ߺ� üũ
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

	// �ߺ� üũ
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

	// �Է� �迭 ����
	public void createTestArr(int iptNum) {
		String iptNumStr = String.valueOf(iptNum);

		for (int i = 0; i < iptNumStr.length(); i++) {
			testArr[i] = iptNumStr.charAt(i) - '0';
		}
	}

	// ��ȿ�� �˻�
	public boolean checkAnswer(int iptNum) {
		createTestArr(iptNum);

		// ���� ��
		int strike = 0;
		int ball = 0;

		for (int i = 0; i < 3; i++) {
			int tmp = testArr[i];

			// ��Ʈ����ũ �˻�
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

	// ���� ���
	public void printAnswer() {
		for (int i = 0; i < randomArr.length; i++) {
			System.out.print(randomArr[i]);
		}
	}
}
