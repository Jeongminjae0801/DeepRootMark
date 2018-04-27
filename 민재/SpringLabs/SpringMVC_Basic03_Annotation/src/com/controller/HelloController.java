package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// HelloController java 파일이 컨트롤러 역할을 하기 위해서는
// Controller 인터페이스가 필요
// 단점 ) 클래스 1개가 역할 1개밖에 못한다

// 기능이 10개면 함수 10개를 만들어야지 클래스 10개를 만들면 어떡해??????????????

// @Controller >> 함수 단위로 mapping 작업이 가능 >> 객체단위의 매핑에서 함수단위 매핑으로 들어옴

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		System.out.println("hello.do start");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting", getGreeting());
		mv.setViewName("Hello"); // resolver를 구현하겠다
		
		return mv;
	}
	
	/*@RequestMapping("")*/
	// 필요하다면 일반함수 만들어서 사용 가능
	public String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour >= 6 && hour <=10) {
			return "학습시간";
		}
		else if (hour>= 11 && hour <= 15) {
			return "배고픈 시간";
		}
		else if (hour>= 16 && hour <= 18) {
			return "집 가는 시간";
		}
		else {
			return "자는 시간";
		}
	}
}
