package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		/*
		MyBean mybean = new MyBean();
		MyBean mybean2 = new MyBean("hong");
		
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		//객체변수의 주소값
		System.out.println("mybean : "+mybean);
		System.out.println("mybean2 : "+mybean2);
		System.out.println("single : "+single);
		System.out.println("single2 : "+single2);
		*/
	
		//KEY POINT : 컨테이너가 구성되고 xml을 read 해서 객체를 생성하고 조립
		//필요하다면 : 컨테이너 안에 있는 객체를 사용해야 한다. >> getBean() >> return Type Object >> casting
		
		//getBean() 는 객체를 만드는 함수가 아니다!
		//getBean() 할때마다 새로운 객체를 가지고 오는 방법이 있나요? > ok
		
		//IOC 컨테이너의 모든 객체의 타입은 : 내부적으로 모두 Singleton 타입 default, 즉 객체 생성은 한번만
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml"); //Spring 컨테이너 생성
		
		System.out.println("before : mybean 객체");
		MyBean mybean = context.getBean("mybean", MyBean.class);
		System.out.println("after : mybean 객체 : " + mybean);
		
		System.out.println("before : mybean2 객체");
		MyBean mybean2 = context.getBean("mybean", MyBean.class);
		System.out.println("after : mybean2 객체 : " + mybean2);
		
		//
		System.out.println("before : mybean3 (생성자)");
		MyBean mybean3 = context.getBean("mybean2", MyBean.class);
		System.out.println("after : mybean3 (생성자) : " + mybean3);
		
		Singleton single =  context.getBean("single",Singleton.class);
		System.out.println(" single객체 : " + single);
		
		Singleton single2 =  context.getBean("single",Singleton.class);
		System.out.println(" single객체 : " + single2);
		
	
	}

}
