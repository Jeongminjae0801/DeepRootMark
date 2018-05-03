package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



//기존 servlet 과 동일한 역활  >> 요청이 오면 실행 > doGET , doPOST >>> handleRequest
public class HelloController implements Controller {

	public HelloController() {
		System.out.println("HelloController 객체 생성 ^^");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행 :handleRequest ");
		//ModelAndView > 데이터를 담을것을 만들고 , view 지정 처리
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "hong"); //request.setAttribute("name","hong")
		mav.setViewName("Hello");
		
		return mav;
	}

}
