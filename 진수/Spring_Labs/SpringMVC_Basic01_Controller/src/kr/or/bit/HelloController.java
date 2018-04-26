package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



//기존 servlet 과 동일한 역할 >> 요청이 오면 실행되던 > doGET, doPost 역할을 >>> handleRequest 가 한다
public class HelloController implements Controller{

	public HelloController() {
		System.out.println("HelloController 객체가 생성되었습니다^^");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행되었습니다 (handleRequest)");
		//ModleAndView > 데이터를 담을것을 만들고, view 지정 처리
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "hong"); //request.setAttribute("name","hong")
		mav.setViewName("Hello");
		
		return mav;
	}

		
}
