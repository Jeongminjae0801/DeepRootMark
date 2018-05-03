package DI_08_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {

		/*JobExecute je = new JobExecute("Woong", 100);	
		// 생성자 주입 (Spring에서 overloading 처리 가능!!)
		
		
		ArticleDao articledao = new ArticleDao();
		je.setArticledao(articledao);	// setter 주입 (주소)
	
		je.setData(500); // setter 주입(값)*/
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_08_Spring/DI_08.xml");
		
		//context.getBean("je");
	}

}
