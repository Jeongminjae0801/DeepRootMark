package DI_06_Spring;

//MySQL, Oracle, Mssql, Sysbase 등 뭐를 사용하던, 동일한 함수(표준화)
public interface ArticleDao {
	
	void insert(Article article);
	
}
