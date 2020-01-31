package multi.erp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Mybatis의 핵심클래스를 이용해서 작성
@Repository("boardDao")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardVO> boardList() {
		//select문의 실행결과가 여러개의 레코드를 반환하는 경우 사용함
		//mapper의 등록한 sql문 id쓰기(namespace포함) -> board.xml에 있음.
		return sqlSession.selectList("multi.erp.board.listall");
	}

	@Override
	public int insert(BoardVO board) {
		return sqlSession.insert("multi.erp.board.insert", board);
	}

	@Override
	public List<BoardVO> searchList(String search) {
		return null;
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		return null;
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

}
