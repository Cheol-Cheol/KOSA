package kosa.subject.oop.video;

public class Runner {

	public static void main(String[] args) {
		Video v1 = new Video("Ʈ��������3", "������");
		Video v2 = new Video("��Ǫ�Ҵ�2", "������");

		GeneralMember m1 = new GeneralMember("cheolcheol", "Ȳö��", "��õ");
		GeneralMember m2 = new GeneralMember("helloWorld", "�����", "��õ");
		m1.rentVideo(v1);
		m2.rentVideo(v2);

		m1.printInfo();
		m2.printInfo();
	}

}
