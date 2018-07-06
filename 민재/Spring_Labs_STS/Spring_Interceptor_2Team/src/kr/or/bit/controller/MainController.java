package kr.or.bit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MainController {
	
	@RequestMapping("/main.do")
	public String main() {
		
		return "/WEB-INF/view/main.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login() {
	
		return "/WEB-INF/view/login.jsp";
	}
	
	@RequestMapping("/write.do")
	public String write() {
		
		return "/WEB-INF/view/write.jsp";
	}
	
	@RequestMapping("/update.do")
	public String update() {
		
		return "/WEB-INF/view/update.jsp";
	}
	
	@RequestMapping("/delete.do")
	public String delete() {
		
		return "/WEB-INF/view/delete.jsp";
	}
	
	@RequestMapping("/loginOk.do")
	public String loginOk(HttpServletRequest request) {
		
		request.getSession().setAttribute("loginInfo", request.getSession().toString());
		return "/WEB-INF/view/main.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {

		request.getSession().invalidate();
		System.out.println("logout : " + request.getSession().getAttribute("loginInfo"));
		return "/WEB-INF/view/login.jsp";
	}
}