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

	// 대여하기
	public void rentVideo(Video video) {
		rentedVideo = video;
	}

	// 출력하기(회원 + 비디오)
	public void printInfo() {
		System.out.println("회원의 아이디: " + this.memberId);
		System.out.println("회원의 이름: " + this.name);
		System.out.println("회원의 주소: " + this.address);
		System.out.println("회원이 대여한 비디오 번호: " + rentedVideo.getVideoNo());
		System.out.println("회원이 대여한 비디오 제목: " + rentedVideo.getTitle());
		System.out.println("회원이 대여한 비디오 배우: " + rentedVideo.getActor());
		System.out.println("------------------------------------------------------------");
	}
}
