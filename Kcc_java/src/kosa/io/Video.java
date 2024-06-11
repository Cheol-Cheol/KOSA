package kosa.io;

import java.io.Serializable;

public class Video implements Serializable{

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

	@Override
	public String toString() {
		return "Video [videoNo=" + videoNo + ", title=" + title + ", actor=" + actor + "]";
	}

}
