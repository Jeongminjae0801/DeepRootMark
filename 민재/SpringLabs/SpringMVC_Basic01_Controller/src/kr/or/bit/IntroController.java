package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller{

	public IntroController() {
		System.out.println("[ IntroController 객체 생성 ] 빠빰 ");
	}
	
	// handleRequest -> servlet (doGet/doPost) 역할
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("introController 요청 실행 : handleRequest ");
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "bituser"); //request.setAttribute() 
		
		// 이름만 지정해주자
		mav.setViewName("intro");	// WEB_INF/views/board/intro.jsp
		
		return mav;
	}

}
