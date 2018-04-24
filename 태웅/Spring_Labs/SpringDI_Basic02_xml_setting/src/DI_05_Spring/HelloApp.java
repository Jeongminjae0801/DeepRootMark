package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import DI_04_Spring.MessageBean;

public class HelloApp {
	public static void main(String[] args) {
		/*MyBean mybean = new MyBean();
		MyBean mybean2 = new MyBean("Woong");
		
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		//객체변수의 주소값
		System.out.println("mybean : " + mybean);
		System.out.println("mybean2 : " + mybean2);
		System.out.println("single : " + single);
		System.out.println("single2 : " + single2);*/
		
		/***************************************************
		 * KEY POINT: 컨테이너가 구성되고 xml read 해서 객체생성 조립.
		 * 필요하다면, 컨테이너 안에 있는 객체를 사용해야 한다. >> getBean() >> return Object >> casting
		 * ※ getBean()은 객체를 만드는 함수가 아니다!!!! >> 같은 id인 객체를 여러번 불러도 주소값은 같다.
		 ****************************************************/
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
		
		System.out.println("----------------------------------------------------------<객체 사용>-----");
		System.out.println("Before: mybean 객체");
		MyBean mybean = context.getBean("mybean", MyBean.class);
		System.out.println("After: mybean 객체" + mybean);
		
		System.out.println("Before RE: mybean 객체");
		MyBean re_mybean = context.getBean("mybean", MyBean.class);
		System.out.println("After RE: mybean 객체" + re_mybean);
		//IoC 컨테이너의 모든 객체의 타입은 모두 Singleton 타입
		
		System.out.println("Before: mybean2 객체");
		MyBean mybean2 = context.getBean("mybean2", MyBean.class);
		System.out.println("After: mybean2 객체" + mybean2);
		
		Singleton single = context.getBean("single", Singleton.class);
		System.out.println(single);
		
		Singleton single2 = context.getBean("single2", Singleton.class);
		System.out.println(single2);
	}
}
