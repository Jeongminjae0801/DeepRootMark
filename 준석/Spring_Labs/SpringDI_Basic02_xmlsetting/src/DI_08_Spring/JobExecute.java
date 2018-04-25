package DI_08_Spring;


//주입 되는 parameter 
public class JobExecute {
	
	public JobExecute(String first, int second) {
		System.out.println("String,int");
	}
	public JobExecute(String first, long second) {
		System.out.println("String,long");
	}
	public JobExecute(String first, String second) {
		System.out.println("String,String");
	}

	private ArticleDao articleDao;

	public ArticleDao getArticleDao() {
		return articleDao;
	}
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
		System.out.println("ArticleDao : " + this.articleDao);
	}
	
	private int data;
	
	public void setData(int data) {
		this.data = data;
		System.out.println("data value :" + this.data);
	}
	
}
