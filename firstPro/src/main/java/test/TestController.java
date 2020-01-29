package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController{
	@RequestMapping("/test.do")
	public ModelAndView test() {
		System.out.println("컨트롤러 요청 완료");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","스프링컨트롤러에서 넘긴 데이터");
		mav.setViewName("test/result");
		return mav;
	}

}
