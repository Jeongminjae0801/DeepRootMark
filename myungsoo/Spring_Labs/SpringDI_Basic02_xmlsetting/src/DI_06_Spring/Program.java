package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {
	
	public static void main(String[] args) {
		//oracle 연동
		//요청-> 글쓰기
/*		OracleArticleDao articledao = new OracleArticleDao();
		WriteArticleService servie = new WriteArticleService(articledao);
		Article article = new Article();
		servie.write(article);*/
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		WriteArticleService service = context.getBean("service",WriteArticleService.class);
		Article article = context.getBean("article",Article.class);
		service.write(article);
	}

}
