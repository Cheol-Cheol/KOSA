package kosa.subject.randomSeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

	private static List<String> studentNames = new ArrayList<>(
			Arrays.asList("�����", "�迬ȣ", "�迵��", "������", "������", "��¿�", "������", "�۵�ȣ", "�ۿ���", "�ȼ���", "�쿵��", "���¾�", "������",
					"�����", "��ä��", "�̼�ȣ", "�̿���", "���־�", "������", "������", "���", "������", "���¿�", "Ȳö��"));

	private List<Seat> randSeats;

	public Service() {
		randSeats = new ArrayList<Seat>();
	}

	public void createRandSeat() {
		//
		while (true) {
			int randNum = (int) (Math.random() * 24); // 0 ~ 23
			String studentName = studentNames.get(randNum);

			if (!randSeats.contains(studentName)) { // ���ԵǾ����� �ʴٸ�?
				// new Seat()
			}

			if (randSeats.size() == 24) {
				break;
			}
		}

		System.out.println("�л����� ���� �¼� ��ġ�� �Ϸ�Ǿ����ϴ�.");
	}

	// ������ �¼� ���(�л��̸�)
	public void printResult() {
		// randSeats ���
	}
}
