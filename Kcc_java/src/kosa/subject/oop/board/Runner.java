package kosa.subject.oop.board;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("#원하시는 게시판 용량을 입력해주세요.");
		System.out.print(">> ");
		int size = Integer.parseInt(sc.next());

		BoardService boardService = new BoardService(size);

		while (true) {
			System.out.println("1. 게시글 생성 | 2. 게시글 전체 조회 | 3. 게시글 수정 | 4. 게시글 삭제 | 5. 서비스 종료");
			System.out.print(">> ");
			int cmd = Integer.parseInt(sc.next());

			int postNum;
			switch (cmd) {
			// 생성
			case 1:
				System.out.print("#글 제목: ");
				String title = sc.next();
				System.out.print("#작성자명: ");
				String name = sc.next();
				System.out.print("#글 내용: ");
				String content = sc.next();

				boardService.addPost(title, name, content);

				break;
			// 전체 조회
			case 2:
				boardService.getAllPosts();
				break;
			// 수정
			case 3:
				System.out.println("#수정할 게시글의 번호를 입력해주세요.");
				System.out.print(">> ");
				postNum = Integer.parseInt(sc.next());

				boardService.updatePost(postNum);

				break;
			// 삭제
			case 4:
				System.out.println("#삭제할 게시글의 번호를 입력해주세요.");
				System.out.print(">> ");
				postNum = Integer.parseInt(sc.next());

				boardService.deletePost(postNum);

				break;
			// 종료
			case 5:
				System.out.println("서비스를 종료합니다.");
				return;
			default:
				System.out.println("#1~4번중에서 선택해주세요.");
				continue;
			}
		}
	}

}
