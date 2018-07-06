package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	
	public static void main(String[] args) {
		//java 코드
	/*	MessageBeanimpl messagebean = new MessageBeanimpl("hong");	//name 생성자 초기화
		messagebean.setGreeting("hello");	//greeting 는 setter 함수에서 초기화
		
		messagebean.sayHello();*/
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		
		MessageBean messagebean = context.getBean("m2", MessageBean.class);
		messagebean.sayHello();
		
	}

}

