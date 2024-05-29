package kosa.subject.oop.video;

public class GeneralMember {

	private String memberId;
	private String name;
	private String address;
	private Video rentedVideo;

	public GeneralMember() {
	}

	public GeneralMember(String memberId, String name, String address) {
		this.memberId = memberId;
		this.name = name;
		this.address = address;
	}

	// �뿩�ϱ�
	public void rentVideo(Video video) {
		rentedVideo = video;
	}

	// ����ϱ�(ȸ�� + ����)
	public void printInfo() {
		System.out.println("ȸ���� ���̵�: " + this.memberId);
		System.out.println("ȸ���� �̸�: " + this.name);
		System.out.println("ȸ���� �ּ�: " + this.address);
		System.out.println("ȸ���� �뿩�� ���� ��ȣ: " + rentedVideo.getVideoNo());
		System.out.println("ȸ���� �뿩�� ���� ����: " + rentedVideo.getTitle());
		System.out.println("ȸ���� �뿩�� ���� ���: " + rentedVideo.getActor());
		System.out.println("------------------------------------------------------------");
	}
}
