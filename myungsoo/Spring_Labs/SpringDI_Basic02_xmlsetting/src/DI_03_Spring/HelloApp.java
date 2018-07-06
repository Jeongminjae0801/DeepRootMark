package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	
	public static void main(String[] args) {
		//영문
				//MessageBean_en messagebean_en = new MessageBean_en();
				//messagebean_en.sayHello("hong");
				
				//한글
				//MessageBean_kr messagebean_kr = new MessageBean_kr();
				//messagebean_kr.sayHello("hong");

				//interface 다형성  ...
				//MessageBean messagebean = new MessageBean_kr();
				//messagebean.sayHello("hong");
		
			ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
			MessageBean message = context.getBean("message", MessageBean.class);
			message.sayHello("hong");
	}

}

/*
	요구사항
	messagebean
	영문버전(hong) -> Hellod hong
	한글버전 (hong) -> 안녕 ㅙㅜㅎ
	결과를 나누어서 출력
	인터페이스를 구현 되었으면..
	
	>messagebean_kr
	>messagebean_en
	>위 두개 클래스는 같은 interface를 구현...

	
*/