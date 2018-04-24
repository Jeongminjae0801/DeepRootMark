package DI_06_Spring;

//Mysql, Oracle, Mssql, Sysbase 어느것을 사용하던 동일한 함수로 (표준화)
public interface ArticleDao {
	void insert(Article article);
}
