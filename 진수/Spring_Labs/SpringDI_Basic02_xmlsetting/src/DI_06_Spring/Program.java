package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		//Oracle 연동
		//요청 -> 글쓰기
		/*
		  JAVA 코드
		//OracleArticleDao articledao = new OracleArticleDao();
		MysqlArticleDao articledao = new MysqlArticleDao();
		WriteArticleService service = new WriteArticleService(articledao);
		Article article = new Article();
		service.write(article);
		*/

		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml"); //Spring 컨테이너 생성
		
		
		WriteArticleService service = context.getBean("service", WriteArticleService.class);
		Article article = context.getBean("article", Article.class);
		
		service.write(article);
		
		
	}

}
