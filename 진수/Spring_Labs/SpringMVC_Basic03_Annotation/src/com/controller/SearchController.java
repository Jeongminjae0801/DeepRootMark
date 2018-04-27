package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	/* 

	방법_2 & 방법_4를 많이 쓴다(ex 페이징 처리 할때)
	
	WEB : Client 전송 데이터 -> Server 데이터 받기 (회원가입 데이터, 게시판입력 데이터)
	
	
	방법_1 : 전통인 방법(request 객체로 받는것)
	void searchInternal(HttpServletRequest request){
		String id = request.getParameter("id");
	}
	
	방법_2 : DTO 객체를 통해서 받는 방법 (게시판 데이터, 회원 가입 ...)
		 : 선행조건 : ?id=hong&name=김유신&age=100		==	dto 객체의 memberfield 명과 같다
		 : input 태그 : name = "id"
	void searchInternal(MemverDto member){
		IOC 컨테이너에 자동으로 객체 생성 ...
		자동으로 주입 (값...)
		View 페이지 까지 전달... (하는것도 자동으로..) 단, (memberDto 로 앞글자만 소문자로 바뀌어 key 만들어져 전달)
	}
	
	방법_3 : Spring Annotation > @RequestParam
	위 의 방법_1, 방법_2 단점이라고 하면 (유효성 체크 를 할 수 없었다)
	@RequestParam (간단한 유효성 처리, 기본값에 대한 설정)
	
	방법_4 : (편하게하는것 : 객체 단위로 받지 않는 값들 )
	void searchInternal(int page, int number)
	** 넘어오는 parameter 이름이 함수의 parameter 명과 같으면 ... END
	** 예를 들어 internal.do?page=100&number=1000 이렇게 파라미터가 넘어오면, 자동으로 ...
	
	
	방법_5 : @PathVariable /member/{memberid}
	
	게시판 : http://cafe.naver.com/bitcamp104/1358 꼭 알고 외워야함
	 */
	
	//방법_3
	@RequestMapping("/search/internal.do")
	public ModelAndView searchInteral(@RequestParam("query") String query,
									  @RequestParam("p") int p) {
		
		System.out.println("Param query : " + query);
		System.out.println("param p : " + p);
		return new ModelAndView("search/internal");
	}
	
	
	/*
	Default: <a href="search/external.do?query=hong">external.do</a>
	
	Default2:<a href="search/external.do?p=100">external.do</a>
	
	Required :<a href="search/external.do">external.do</a>
	
	paramter name: <a href="search/external.do?query=kim&p=1000">external.do</a>
	
	*/
	
	/*
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(@RequestParam(value="query" , required=false)  String query ,
			                           @RequestParam(value="p",defaultValue="1") int p){
		System.out.println("param query : " + query);
		System.out.println("param p :" + p);
		return new ModelAndView("search/internal");
	}
	*/
	/*
	//활용한다면 게시판 List 페이지에 (기본값(defaultValue="default")을 설정해야 할때 쓰면 별도로 로직처리 할 필요 없어, 편하다 ...)
	@RequestMapping("/search/external.do")
	public ModelAndView searchExteral(@RequestParam(value="query", defaultValue="default") String query,
									  @RequestParam(value="p", defaultValue="1") int p) { //defaultValue="1" == oracle sysdate default 로 잡는것같은 효과
		
		System.out.println("Param query : " + query);
		System.out.println("param p : " + p);
		return new ModelAndView("search/internal");
	}
	*/

	//방법_4(편하게 : 객체단위로 받지 않는 값들 )
	//단 ?query=aaa&p=100  > 함수의 parameter 이름과 동일 > 유효성 처리 안됨
	@RequestMapping("/search/external.do")
	public ModelAndView searchExternal(String query , int p){
		System.out.println("param query : " + query);
		System.out.println("param p :" + p);
		return new ModelAndView("search/internal");
	}
	
	
}
