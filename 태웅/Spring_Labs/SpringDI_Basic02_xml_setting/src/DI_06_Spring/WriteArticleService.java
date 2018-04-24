package DI_06_Spring;

//요청을 판단 (DAO 또는 DTO 생성하던 ...)
public class WriteArticleService {
	private ArticleDao dao;
	
	public WriteArticleService(ArticleDao dao) {
		this.dao = dao;
		System.out.println("WriteArticleService 생성자 호출");
	}
	
	public void write(Article article) {
		this.dao.insert(article);
	}
}
