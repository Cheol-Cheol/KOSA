package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;

//	@Test
//	public void test() {
//
//		mapper.getList().forEach(board -> log.info(board));
//	}

//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로운글2");
//		board.setContent("새로 작성한 글2");
//		board.setWriter("newUser2");
//
//		mapper.insert(board);
//	}

//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로운글3");
//		board.setContent("새로 작성한 글3");
//		board.setWriter("newUser3");
//
//		// bno을 DB에 데이터로 저장하기 직전에 알고 싶을 경우
//		mapper.insertSelectKey(board);
//		log.info(board); // BoardVO(bno=3, title=새로운글3, ...)
//	}

//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(3L);
//		log.info(board);
//	}

//	@Test
//	public void testDelete() {
//
//		log.info("Delete count: " + mapper.delete(3L));
//	}

	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(2L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");

		int count = mapper.update(board);
		log.info("update count: " + count);
	}
}