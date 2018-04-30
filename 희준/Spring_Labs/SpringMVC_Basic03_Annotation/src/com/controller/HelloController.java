package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//HelloController java 파일이 Controller 역활하기 위해서  implements Controller 통해서
//단점 : Controller 파일 하나가 기능한가지만 처리 ....
//아니 기능이 10가지면 함수 10개를 만들어야지 class 10개를 만들면 되나 ???

//@Controller >> 함수 단위로 mapping 작업이 가능(@RequestMapping) >> 객체단위의 매핑에서 >> 함수단위의 매핑

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		System.out.println("[hello.do start]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting",getGreeting());
		mv.setViewName("Hello"); 
		return mv;
	}
	
	//필요하다면 일반 함수 만들어서 사용가능
	public String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data="";
		if(hour >= 6 && hour <= 10) {
			data = "학습시간";
		}else if(hour >= 11 && hour <= 15) {
			data = "배고픈 시간";
		}else if(hour >= 16 && hour <= 18) {
			data = "졸려운 시간";
		}else {
			data = "go home";
		}
		return data;
	}
}




