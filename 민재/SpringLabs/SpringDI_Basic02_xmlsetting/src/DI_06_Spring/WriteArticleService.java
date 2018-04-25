package DI_06_Spring;

// 요청 판단 DAO 생성 / DTO 생성 하던 알아서 판단하라
public class WriteArticleService {
	
	private ArticleDao articledao;
	public WriteArticleService(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("WriteArticleService 생성자 호출");
	}
	
	// 사용자 요청 (글쓰기)
	public void write(Article article) {
		this.articledao.insert(article);
	}
}
