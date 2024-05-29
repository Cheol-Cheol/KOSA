package kosa.subject.oop.board;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("#���Ͻô� �Խ��� �뷮�� �Է����ּ���.");
		System.out.print(">> ");
		int size = Integer.parseInt(sc.next());

		BoardService boardService = new BoardService(size);

		while (true) {
			System.out.println("1. �Խñ� ���� | 2. �Խñ� ��ü ��ȸ | 3. �Խñ� ���� | 4. �Խñ� ���� | 5. ���� ����");
			System.out.print(">> ");
			int cmd = Integer.parseInt(sc.next());

			int postNum;
			switch (cmd) {
			// ����
			case 1:
				System.out.print("#�� ����: ");
				String title = sc.next();
				System.out.print("#�ۼ��ڸ�: ");
				String name = sc.next();
				System.out.print("#�� ����: ");
				String content = sc.next();

				boardService.addPost(title, name, content);

				break;
			// ��ü ��ȸ
			case 2:
				boardService.getAllPosts();
				break;
			// ����
			case 3:
				System.out.println("#������ �Խñ��� ��ȣ�� �Է����ּ���.");
				System.out.print(">> ");
				postNum = Integer.parseInt(sc.next());

				boardService.updatePost(postNum);

				break;
			// ����
			case 4:
				System.out.println("#������ �Խñ��� ��ȣ�� �Է����ּ���.");
				System.out.print(">> ");
				postNum = Integer.parseInt(sc.next());

				boardService.deletePost(postNum);

				break;
			// ����
			case 5:
				System.out.println("���񽺸� �����մϴ�.");
				return;
			default:
				System.out.println("#1~4���߿��� �������ּ���.");
				continue;
			}
		}
	}

}
