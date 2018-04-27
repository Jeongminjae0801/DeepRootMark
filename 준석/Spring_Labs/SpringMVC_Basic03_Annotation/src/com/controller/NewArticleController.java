package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

@Controller
@RequestMapping("/article/newArticle.do") //GET 방식 요청 , POST 방식 요청
public class NewArticleController {
	
	private ArticleService articleservice;
	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}
	
	
	//**하나의 요청 주소로 : 2가지  판단 (GET ,POST) > method=GET , method=POST
	//글쓰기 (GET), 글쓰기 완료 (POST)
	
	

	//GET 방식 요청 (사용자 화면단 제공)
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		System.out.println("GET 방식에 대한 요청");
		return "article/newArticleForm";
		
		//ViewResolver 에 의해서
		//  /WEB-INF/views/article/newArticleForm.jsp
	}
	//1. 전통적으로 Client 요청 데이터 받기(Spring 에서 더 이상 사용 안해요)
	/*
	@RequestMapping(method=RequestMethod.POST)
	public String submit(HttpServletRequest request) {
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		articleservice.writeArticle(article);
			
		return "article/newArticleSubmitted";
	}
	*/
	
	//public String submit(NewArticleCommand command{
	//동작 원리: JSP (UseBean Action 태그 사용 : setProperty ...)
	
	//전제조건 : Form 태그의 name 속성의 이름이 DTO 객체의 memberfield 와 같아야한다.
	//<input type="text" name="title"> >> private String title;
	
	//submit(NewArticleCommand command) 함수의 parameter DTO 타입을 사용
	//넘어오는 parameter 가 DTO 타입의 memberfield 명과 같다면
	//1. 자동으로 DTO 객체 생성 : NewArticleCommand newArticleCommand = new NewArticleCommand();
	//2. 자동으로 넘어온 parameter 값을 setter 함수를 이용하여 자동 주입
	//1.1 NewArticleCommand 객체 IOC 컨테이너에 id="newArticleCommand" 자동 생성.....
	//원칙 : ModelAndView mv = new ModelAndView();  , mv.addObject("NewArticleCommand", NewArticleCommand); return mv;
	// 위 원칙이 없어도 view 페이지에 DTO객체(NewArticleCommand) 주소가 자동 forward ....
	
	/*
		1. submit(NewArticleCommand command)
			>자동 객체 생성 되고 객체변수명이 (key) : newArticleCommand
			
		2. 이름이 자동으로 생성되는 것이 싫어요
		
			submit(@ModelAttribute("Articledata")NewArticleCommand command)
			//자동으로 생성되는 객체변수명을 제어 (Articledata 강제) key : Articledata
	 	
		3. Model.addAttribute("Articledata" , new NewArticleCommand()); 자동 .....
	
	
	
	
	
	
	*/
	//POST 방식 요청 (DB단 처리 Insert 처리)
	@RequestMapping(method=RequestMethod.POST)
	//public String submit(NewArticleCommand command) {
	public String submit(@ModelAttribute("Articledata")NewArticleCommand command) {
		//1.parameter 받기
		//2.Service 객체 생성하기  ArticleService service = new ArticleService()
		//3.Service 객체 함수 호출하기
		//4.결과받아서 return 하기
		
		articleservice.writeArticle(command);
		return "article/newArticleSubmitted";
	}
	
}
