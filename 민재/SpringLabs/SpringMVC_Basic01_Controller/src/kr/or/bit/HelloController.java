package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
 
// 기존에 있는 servlet 과 동일한 역할
// 요청이 오면 실행 -> doGet , doPost == handleRequest
public class HelloController implements Controller{

	public HelloController() {
		System.out.println("[ helloController 객체 생성 ] 뚜뚱 ");
		
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행 : handleRequest ");
		// ModelAndView >> 데이터를 담을것을 만들고 view를 지정해서 처리
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "min");
		mav.setViewName("Hello");
		return mav;
	}
	
}
