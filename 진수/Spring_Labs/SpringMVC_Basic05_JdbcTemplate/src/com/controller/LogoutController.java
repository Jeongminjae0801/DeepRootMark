package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); //로그아웃
		return "loginForm";
	}
}
