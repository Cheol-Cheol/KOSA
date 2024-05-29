package kosa.subject.oop.video;

public class Video {

	private static int id = 0;
	private int videoNo;
	private String title;
	private String actor;

	public Video() {
	}

	public Video(String title, String actor) {
		id += 1;
		videoNo = id;
		this.title = title;
		this.actor = actor;
	}

	public int getVideoNo() {
		return videoNo;
	}

	public String getTitle() {
		return title;
	}

	public String getActor() {
		return actor;
	}

	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

}
