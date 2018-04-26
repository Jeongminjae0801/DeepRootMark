package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller{
	
	public IntroController() {
		System.out.println("IntroController 객체 생성되었습니다 ^^");
	}
	
	//handleRequest > servlet (doGET, doPOST) 역할을 한다
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IntroController 요청 실행되었습니다 (handleRequest)");
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "bituser"); //기존 webJSP 에서 request.setAttribute() 와 같은것
		mav.setViewName("Intro"); //기존 webJSP 에서 WEB-INF/views/board/intro.jsp 같은것
		return mav;
	}

	
	
}
