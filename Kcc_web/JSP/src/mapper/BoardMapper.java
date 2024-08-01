package mapper;

import java.util.List;
import java.util.Map;

import servlet.model.Board;
import servlet.model.Search;

public interface BoardMapper {

	List<Board> listBoard(Search search);

	Board detailBoard(int seq);

	int insertBoard(Board board);

	int updateBoard(Board board);
}
