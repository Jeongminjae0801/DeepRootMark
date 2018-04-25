package AOP_Basic_Spring_04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		
		// Proxy 객체를 생성하고 Proxy를 통해서 함수를 실행
		// Spring xml 설정을 통해서
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:AOP_Basic_Spring_04/ApplicationContext.xml");
		
		Calc calc = context.getBean("proxy",Calc.class);
		int result = calc.Add(10, 20);
		System.out.println(result);
	}
}
