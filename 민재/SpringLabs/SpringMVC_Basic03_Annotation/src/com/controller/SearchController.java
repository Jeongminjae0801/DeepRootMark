package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
/*	Web에서 중요한 것 : 클라이언트가 전송한 데이터를 서버에서 데이터 받는 것
	 (회원가입 데이터, 게시판 입력 데이터)
	 
	 방법 : 전통적인 방법 = request 객체 사용
	 	ex) void searchInternal(HttpServletRequest request){
	 				String id = request.getParameter("id")
		  	}
		  
	 방법2 : DTO 객체를 통해서 받는 방법
	  	 : 선행조건 : ?id=hong&name=...&age=10
	  	 : 넘어오는 파라미터의 이름과 DTO 객체의 멤버필드 명이 똑같아야 한다
	  	 : input 태그 : name="id"
	 	ex) void searchInternal(MemberDTO member){
	 			IOC 컨테이너에 자동으로 객체가 생성되고
	 			자동으로 주입(값)되고 view 페이지까지 전달(memberDTO key가 만들어져 전달)
	 	  	}
	 
	 방법3 : Spring이 제공하는 Annotation 사용
	 		-> @RequestParam
	 		방법 1, 방법 2의 단점은 유효성 체크가 안된다
	 		@RequestParam (간단한 유효성 처리, 기본값에 대한 설정)편하게 할 수 있다
	 
	 방법4 : 편하게 하는 방법 :: 객체로 받지 않는 값들
	 		void searchInternal (int page, int number)
	 		---- 넘어오는 파라미터 이름이 함수의 파라미터 명과 같으면 end
	 		---- internal.do?page=100&number=1000
	 		
	 방법5 : @PathVariable -> /member/{memberid}  -> 주소의 마지막값을 파라미터로*/
	 
	//////////////////////////////////////////////////
	// 방법 3
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(@RequestParam("query") String query,
										@RequestParam("p") int p) {
		System.out.println("방법 3: param query : " + query);
		System.out.println("방법 3: param p : " + p);
		return new ModelAndView("search/internal");
				
	}
	////////////////////////////////////////////
	// default 값 잡기 --> 게시판 List 페이지에 기본값 설정 시 활용하면 좋다
	/*
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(@RequestParam(value="query", required=false) String query,
										@RequestParam(value="p", defaultValue="1") int p) {
		System.out.println("param query : " + query);
		System.out.println("param p : " + p);
		return new ModelAndView("search/internal");
				
	}*/
	//////////////////////////////////////////////
	// 방법 4 (편하게 : 객체단위로 받지 않는 값들)
	// 단 ?query=aaa&p=100 --> 함수의 파라미터 이름과 동일해야 한다 -> 유효성 체크는 안됨
	// default 값 잡아놓으면 에러 터짐
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(String query, int p) {
		System.out.println("방법 4: param query : " + query);
		System.out.println("방법 4: param p : " + p);
		return new ModelAndView("search/internal");
				
	}
}
