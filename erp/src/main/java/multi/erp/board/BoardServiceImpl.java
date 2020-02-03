package multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//dao의 메소드를 호출하는 클래스
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("boardDao")
	BoardDAO dao;
	
	@Override
	public List<BoardVO> boardList(String category) {
		List<BoardVO> list = null;
		if (category!=null) {
			if(category.equals("all")) {
				list = dao.boardList();
			}else {
				list = dao.categorySearch(category);
			}
		}
		return list;
	}

	@Override
	public int txinsert(BoardVO board) {
		return 0;
	}

	@Override
	public int insert(BoardVO board) {
		return dao.insert(board);
	}

	@Override
	public List<BoardVO> searchList(String search) {
		return null;
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		return dao.searchList(tag, search);
	}

	@Override
	public List<BoardVO> pageList() {
		return null;
	}

	@Override
	public BoardVO read(String board_no) {
		return null;
	}

	@Override
	public int update(BoardVO board) {
		return 0;
	}

	@Override
	public int delete(String board_no) {
		return 0;
	}

	@Override
	public List<BoardVO> findByCategory(String category) {
		return null;
	}

}


