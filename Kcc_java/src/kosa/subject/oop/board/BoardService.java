package kosa.subject.oop.board;

public class BoardService {

	private Board[] posts;
	private int idx;

	public BoardService(int size) {
		posts = new Board[size];
		idx = 0;
	}

	// �Խñ� ����
	public void addPost(String title, String name, String content) {
		posts[idx++] = new Board(title, name, content);
		System.out.println("#�Խñ��� ��ϵǾ����ϴ�.");
	}

	// �Խñ� ��ü ���
	public void getAllPosts() {
		for (int i = 0; posts[i] != null; i++) {
			System.out.println(posts[i].toString());
		}
	}

	// �Խñ� ����
	public void updatePost(int num) {
		for (int i = 0; posts[i].getBoardId() == num - 1; i++) {
			
		}
	}

	// �Խñ� ����
	public void deletePost(int num) {
		for (int i = 0; posts[i].getBoardId() == num; i++) {
			posts[i] = posts[i + 1];
		}
		idx--;
		System.out.println("�Խñ��� �����Ǿ����ϴ�.");
	}
}
