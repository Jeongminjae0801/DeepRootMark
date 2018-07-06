package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	//필요하다면
	//HttpServletResponse parameter  사용가능
	//make(HttpServletResponse response , HttpServletRequest request)
	
	
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		response.addCookie(new Cookie("auth","1004"));
		return "cookie/CookieMake";
	}
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth" , defaultValue="0") String auth) {
		System.out.println("클라이언트에서 read 한 쿠키값 : " + auth);
		return "cookie/CookieView";
	}
}
