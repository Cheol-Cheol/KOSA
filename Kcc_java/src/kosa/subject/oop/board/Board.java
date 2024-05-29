package kosa.subject.oop.board;

import java.time.LocalDate;

public class Board {

	private static int cnt = 0;
	private int BoardId;
	private String title;
	private String name;
	private String content;
	private LocalDate createdAt;

	public Board() {
	}

	public Board(String title, String name, String content) {
		this.cnt += 1;
		this.BoardId = cnt;
		this.title = title;
		this.name = name;
		this.content = content;
		this.createdAt = LocalDate.now();
	}

	public int getBoardId() {
		return BoardId;
	}

	public void setBoardId(int boardId) {
		BoardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "[" + BoardId + "번 게시글" + "] \n" + "제목: " + title + "\n작성자명: " + name + "\n내용: " + content + "\n생성일: "
				+ createdAt;
	}

}
