package multi.erp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Mybatis의 핵심클래스를 이용해서 작성
//sql문 하나당 메소드 하나를 만들어야한다.
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
	public List<BoardVO> categorySearch(String category) {
		//category를 이용해서 쓸꺼니까 boardList와 같은 select여도 아래처럼 category를 받을 수 있게 해줘야됨.
		return sqlSession.selectList("multi.erp.board.categorySearch", category);
	}
	
	//검색어별로 조회 - 동적SQL활용
	@Override
	public List<BoardVO> searchList(String tag, String search) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("search", search);
		
		return sqlSession.selectList("multi.erp.board.dynamicSearch",map);
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
