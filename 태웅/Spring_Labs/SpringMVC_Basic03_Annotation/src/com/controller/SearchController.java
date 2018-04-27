package com.controller;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
WEB: Client 전송 데이터 --> Server 데이터 받기(회원가입데이터, 게시판 입력데이터)

방법:	1.전통적(request 객체)
	void searchInternal(HttpServletRequest request) {
		String id = request.getParameter("id");
	}
	
	☆★☆★
	2.DTO(MemberDTO) 객체를 통해서 받는 방법
	[선행조건]DTO객체의 'memberfield 변수명'과 input태그의 'name 속성값'이 같아야 한다.
	void searchInternal(MemberDTO member) {
		IOC 컨테이너에 자동으로 객체 생성 후... 자동 주입...
		View 페이지까지 전달...(memberDTO로 key가 만들어져 전달)
	}
	
											(※ 방법 1,2의 단점은 유효성 체크)
	
	3.Spring Annotation >> @RequestParam
	: 간단한 유효성 처리, 기본값에 대한 설정
	
	☆★☆★☆
	4.편하게: 객체 단위로 받지 않는 값들 
	: 넘어오는 parameter 이름이 함수의 parameter 이름과 같다면... END
	: internal.do?page=100&number=1000
	void searchInternal(int page, int number) {}
	
	5.@PathVariable
	: /member/{memberfield}
	: [참고] http://cafe.naver.com/bitcamp104/1358
*/

@Controller
public class SearchController {
	
	//방법_3
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInternal(	@RequestParam("query") String query, 
										@RequestParam("p") int p) {
		
		System.out.println("param query: " + query);
		System.out.println("param p: " + p);
		
		return new ModelAndView("search/internal");
	}
	
	//방법_3
	//활용]게시판 List페이지에 페이지 기본값 설정시 Good!!
	/*@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(	@RequestParam(value="query", defaultValue="???") String query, 
										@RequestParam(value="p", defaultValue="-") int p) {
		
		System.out.println("param query: " + query);
		System.out.println("param p: " + p);
		
		return new ModelAndView("search/internal");
	}*/
	
	//방법_4
	//단, name이 함수의 parameter이름과 동일해야함. 유효성 처리 안됨.
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(	String query, int p ) {
		
		System.out.println("param query: " + query);
		System.out.println("param p: " + p);
		
		return new ModelAndView("search/internal");
	}
	
}
