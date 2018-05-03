package com.service;

import com.model.NewArticleCommand;

public class ArticleService {
	
	public ArticleService() {
		System.out.println("[ ArticleService ]");
	}
	
	public void writeArticle(NewArticleCommand command) {
		//가정: DAO 객체 생성 & 함수 호출
		//ArticleDao dao = new ArticleDao();
		//dao.insertArticle(command)
		System.out.println("글쓰기 작업 완료: " + command.toString());
	}
	
}
