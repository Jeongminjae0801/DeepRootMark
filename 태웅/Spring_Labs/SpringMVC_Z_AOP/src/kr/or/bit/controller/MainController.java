package kr.or.bit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("/main.do")
	public String main() {
		
		String path = "redirect:/index.jsp";
		return path;
		
	}
	
	@RequestMapping("/login.do")
	public String login(String id, String pw, HttpServletRequest request) {
		
		String path = "redirect:/index.jsp";
		if (id.toUpperCase().equals("ADMIN") && pw.equals("1004")) {
			request.getSession().setAttribute("USER", id);
			path = "store";
			return path;
        } 
		return path;
		
	}
	
	
	
}
