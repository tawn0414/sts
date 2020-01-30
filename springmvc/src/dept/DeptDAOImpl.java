package dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//이게 내가만드는 사용자정의 dao클래스임
//bean으로 인식시키기 위해 @Repository사용.
@Repository
public class DeptDAOImpl {
	@Autowired //(자동으로 맵핑되도록)
	JdbcTemplate mytemplate;
	public int count() {
		return mytemplate.queryForObject("select count(*) from dept", Integer.class);
	}
	
	public int insert(String deptno, String deptname) {
		String sql = "insert into dept(deptno, deptname) values(?,?)";
		int result = mytemplate.update(sql, deptno,deptname);
		return result;
	}
	
	public int update(String deptno, String deptname) {
		String sql = "update dept set deptname=? where deptno=?";
		int result = mytemplate.update(sql, deptname,deptno);
		return result;
	}
	
	public List<DeptDTO> selectAll() {
		return mytemplate.query("select deptno, deptname from dept", new MyDeptRowMapper());
	}
}
