package kr.or.bit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login(String id, String pw, HttpServletRequest request) {
		if (id.toUpperCase().equals("ADMIN") && pw.equals("1004")) {
			request.getSession().setAttribute("USER", id);
			return "store";
        } 
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/buycar.do")
	public String buyCar(@RequestParam("carName") String car, Model model) {
		/*
			Before
		*/
		
		//주관심사 ////////////////
		System.out.println(car);
		///////////////////////
		
		/*
			@After
		*/
		return "result";
	}
	
}
