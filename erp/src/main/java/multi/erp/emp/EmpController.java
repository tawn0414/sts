package multi.erp.emp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//emp테이블에서 작업하는 모든 내용에 대한 컨트롤러
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	//로그인 페이지를 보기위한 요청
	@RequestMapping(value= "/emp/login.do", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	//실제 로그인 처리를 위한 요청
	// - 매개변수가 VO객체 :
	// 스프링 MVC내부의 클래스인 DispatcherServlet에서 자동으로 입력된 파라미터들을 추출해서 VO객체를 만들고
	// SETTER메소드의 값으로 전달된다.
	@RequestMapping(value= "/emp/login.do", method = RequestMethod.POST)
	public ModelAndView login(MemberVO loginUserInfo, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		//user => db연동 후 로그인된 사용자의 정보
		//loginUserInfo => 로그인 하기 위해서 사용자가 입력한 테이터를 vo로 만든 객체. 입력한 id와 password
		MemberVO user= service.login(loginUserInfo);
		System.out.println("로그인 사용자 정보: "+user);
		//로그인한 사용자의 정보를 세션에 저장.세선을 쓰기 위해서 매개변수에 HttpServletRequest를 정의했다.
		//[왜?]
		//1. 세션을 생성하하기 위해서 ->  request가 갖고있는 메소드로 생성가능
		//   => getSession()을 통해서 세션을 생성함. 이거는 무조건 생성해서 리턴한다. -> 처음 세션을 만들때
		//      사용하는 것이 적합하다.
		String viewName="";
		if(user!=null) {
			//로그인 성공시
			HttpSession ses = request.getSession();
			//2. 세션에 데이터 공유
			ses.setAttribute("user", user);
			viewName = "index";
		}else {
			//로그인 실패시 로그인 페이지 보여준다는 의미
			viewName = "login";
		}
		mav.setViewName(viewName);//viewName을 변수처리.
		return mav;
	}
	@RequestMapping("/emp/logout.do")
	public String logout(HttpSession session) {
		//로그아웃 처리를 위해 매개변수로 session을 받도록 처리
		//사용하던 세션객체가 있으면 사용하던 세션객체가 전달된다.
		if(session!=null) {
			//null이 아니라 세션이 존재하면 세션객체를 없애는 작업
			session.invalidate();
		}
		return "redirect:/index.do";
	}
}
