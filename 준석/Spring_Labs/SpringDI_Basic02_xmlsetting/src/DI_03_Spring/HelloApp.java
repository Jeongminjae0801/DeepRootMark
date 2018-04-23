package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import DI_04_Spring.MessageBeanImpl;

public class HelloApp {

	public static void main(String[] args) {
		//java code
		//MessageBeanImpl messagebean = new MessageBeanImpl("hong"); //name 생성자 초기화
		//messagebean.setGreeting("hello"); //greeting 는 setter 로 초기화
		//messagebean.sayHello();
		
		//위 코드를 Spring 통해서 (IOC 컨테이너 안에 객체 만들고 주입을 하고 ) > xml파일 또는 Annotation 통해
	}

}
/*
요구사항
MessageBean
영문버전(hong) -> Hellohong!
한글버전(hong) -> 안녕hong!
결과를 나누어서 출력
인터페이스로 구현 되었으면 .....

>MessageBean_kr
>MessageBean_en
>위 두개 클래스는 같은 Interface 를 구현 .....


*/