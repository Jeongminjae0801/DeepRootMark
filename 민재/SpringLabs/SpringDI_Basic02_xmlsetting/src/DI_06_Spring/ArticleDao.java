package DI_06_Spring;

// Mysql , Oracle , Mssql , Sysbase 에서 동일한 함수를 사용하겠다 (표준화)
public interface ArticleDao {
	
	void insert(Article article);
	
}
