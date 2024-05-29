package kosa.subject.oop.board;

public class BoardService {

	private Board[] posts;
	private int idx;

	public BoardService(int size) {
		posts = new Board[size];
		idx = 0;
	}

	// 게시글 생성
	public void addPost(String title, String name, String content) {
		posts[idx++] = new Board(title, name, content);
		System.out.println("#게시글이 등록되었습니다.");
	}

	// 게시글 전체 출력
	public void getAllPosts() {
		for (int i = 0; posts[i] != null; i++) {
			System.out.println(posts[i].toString());
		}
	}

	// 게시글 수정
	public void updatePost(int num) {
		for (int i = 0; posts[i].getBoardId() == num - 1; i++) {
			
		}
	}

	// 게시글 삭제
	public void deletePost(int num) {
		for (int i = 0; posts[i].getBoardId() == num; i++) {
			posts[i] = posts[i + 1];
		}
		idx--;
		System.out.println("게시글이 삭제되었습니다.");
	}
}
