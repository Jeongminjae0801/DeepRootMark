package AOP_Basic_Spring_03;

import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		//proxy 객체 생성
		//proxy 를 통해서 함수 실행
		//Spring xml 설정을 통해서 ...
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:AOP_Basic_Spring_03/ApplicationContext.xml");
		Calc calc = context.getBean("proxy", Calc.class);
		
		int result = calc.ADD(10000, 5000);
		System.out.println("result : "+ result);
		
	}

}
