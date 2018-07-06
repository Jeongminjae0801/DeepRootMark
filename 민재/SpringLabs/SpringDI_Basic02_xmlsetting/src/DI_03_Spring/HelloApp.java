package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {

/*		//영문
		MessageBean_en messagebean_en = new MessageBean_en();
		messagebean_en.sayHello("minjae");
		
		//한글
		MessageBean_kr messagebean_kr = new MessageBean_kr();
		messagebean_kr.sayHello("minjae");
		
		// 인터페이스로 다형성 사용
		MessageBean messagebean = new MessageBean_kr();
		messagebean.sayHello("minjae");
*/
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		// generic은 타입변환을 쉽게 할 수 있다
		MessageBean message = context.getBean("message",MessageBean.class); // 자동 형변환 가능
		message.sayHello("minjae");
		
	}

}
/*
요구사항
	MessageBean 영문 버전과 한글 버전 
	ex) hong -> hello hong
		hong -> 안녕 hong
	결과를 나누어서 출력
	인터페이스로 구현 되었으면 좋겠어요 ===> MessageBean을 2개 만들어라
	>>> MessageBean_kr
	>>> MessageBean_en
	>>> 위 두 개의 클래스는 같은 인터페이스를 구현
*/