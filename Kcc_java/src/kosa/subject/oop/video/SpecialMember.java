package kosa.subject.oop.video;

public class SpecialMember extends GeneralMember {

	private int point;

	public SpecialMember() {
	}

	public SpecialMember(String memberId, String name, String address) {
		super(memberId, name, address);
		this.point = 0;
	}

	@Override
	public void rentVideo(Video video) {
		super.rentVideo(video);
		point += 10;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("회원의 보너스 포인트 적립: " + point + "\n");
	}

	public void specialPrint() {
		System.out.println("이름: " + getName());
		System.out.println("포인트 적립:" + point);
	}
}
