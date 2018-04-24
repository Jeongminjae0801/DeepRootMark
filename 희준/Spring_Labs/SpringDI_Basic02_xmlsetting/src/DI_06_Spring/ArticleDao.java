package DI_06_Spring;

//mysql, Oracle, Mssql, sybase 동일한 함수 (표준화)
public interface ArticleDao {
	void insert(Article article);
}
