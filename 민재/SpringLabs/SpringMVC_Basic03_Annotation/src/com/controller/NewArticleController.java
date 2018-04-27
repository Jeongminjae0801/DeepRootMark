package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.NewArticleCommand;
import com.service.ArticleService;

@Controller
@RequestMapping("/article/newArticle.do") // get 방식 요청 / post 방식 2가지
public class NewArticleController {
	private ArticleService articleservice;
		
	@Autowired	//자동 주입
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}
	
		//하나의 요청 주소로 2가지의 판단을 할 수 있다(GET, POST)
		//글쓰기 (get) , 글쓰기 완료(post)
		
		//get 방식 요청(사용자에게 화면단 제공)
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		System.out.println("GET방식에 대한 요청");
		return "article/newArticleForm";
	}
		
		//post 방식 요청(실제 처리(DB),, insert 처리)
	// public String submit(NewArticleCommand command)
	// 동작 원리 ::: jsp -> UseBean Action 태그 사용 : setProperty 와 비슷
	// 전제 조건 : Form 태그의 name 속성의 이름이 DTO 객체의 멤버 필드명과 똑같아야 한다
	
	// <input type="text" name="title"> >>> private String title;
	// submit(NewArticleCommand command) 함수의 파라미터 DTO 타입을 사용
	// 넘어오는 파라미터가 DTO 타입의 멤버필드 명과 같다면
	// 1. 자동으로 DTO 객체가 생성된다 
	//		NewArticleCommand newArticleCommand = new NewArticleCommand();
	//		를 자동으로 생성
	// 2. 자동으로 넘어온 파라미터 값을 setter 함수를 이용하여 자동 주입을 한다
	//   1) NewArticleCommand 객체 IOC 컨데이너에 id="newArticleCommand" 자동 생성
	
	// 원칙) ModelAndView mv = new ModelAndView();
	//			mv.addObject ............... 이런게 생략됨
	// 위 원칙이 없어도 view 페이지에 DTO 객체에 NewArticleCommand 주소가 자동 forward
	
	/*
		1. submit(NewArticleCommand command)
			-> 자동 객체 생성되고 객체변수명이 key : newArticleCommand
			
		2. 이름이 자동으로 생성되는 것이 싫어
			submit(@ModelAttribute("Articledata")NewArticleCommand command)
			-> 자동으로 생성되는 객체변수명을 제어 (Articledata 강제) key : Articledata
			
		3. Model.addAttribute("Articledata", new NewArticleCommand());
		자동으로 생성된다 
	
	 */
	@RequestMapping(method=RequestMethod.POST)
	/*public String submit(NewArticleCommand command) {*/
	public String submit(@ModelAttribute("Articledata")NewArticleCommand command) {
		// 1. 파라미터 받기 (insert 구문 썻으니까)
		// 2. service객체 생성하기 ArticleService service = new ArticleService()
		// 3. service객체 함수 호출하기
		// 4. 결과 받아 return
		
		articleservice.writeArticle(command);
		return "article/newArticleSubmitted";
	}
}