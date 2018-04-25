package DI_06_Spring;

public class WriteArticleService {
	private ArticleDao Articledao;
	public WriteArticleService(ArticleDao articledao) {
		this.Articledao = articledao;
		System.out.println("WriteArticleServece 생성자 호출");
	}
	
	//사용자 요청(글쓰기)
	public void write(Article article) {
		this.Articledao.insert(article);
	}

}
