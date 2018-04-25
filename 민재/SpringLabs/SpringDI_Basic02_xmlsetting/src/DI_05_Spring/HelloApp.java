package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {

		/*MyBean mybean = new MyBean();
		MyBean mybean2 = new MyBean("min");
		
		Singleton single = Singleton.getInstance();	//스택 메모리에 있는 주소값을 나타냄
		Singleton single2 = Singleton.getInstance();
		
		//객체 변수의 주소값
		System.err.println("mybean : " + mybean);
		System.err.println("mybean2 : " + mybean2);
		System.err.println("single : " + single);
		System.err.println("single2 : " + single2);*/
		////////////    키 포인트       /////////
		// 컨테이너를 구성하고 xml read 해서 객체 생성을 조립한다
		// 필요하다면 컨테이너 안에 있는 객체를 가지고 나와야한다  >> getBean
		
		// getBean()는 객체를 만드는 함수가 아니다
		// 만들어진 객체를 가져오는 것 ===== 만들어진 객체의 주소를 얻어오는 것
		// 그렇다면 getBean()을 할때마다 새로운 객체를 가지고 오는 방법이 있을까 ????????
		
		// IOC 컨테이너의 모든 객체의 타입은 모두 Singleton 이다 (default 값으로 되어있다)
		
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
		
		System.out.println("before : mybean 객체 ");
		MyBean mybean = context.getBean("mybean",MyBean.class);
		System.out.println("after : mybean 객체 : " + mybean);
		
		System.out.println("before : mybean2 객체 ");
		MyBean mybean2 = context.getBean("mybean",MyBean.class);
		System.out.println("after : mybean2 객체 : " + mybean2);
		
		System.out.println("before : mybean3 객체(생성자 ");
		MyBean mybean3 = context.getBean("mybean2",MyBean.class);
		System.out.println("after : mybean3 객체(생성자) : " + mybean3);
		
		Singleton single = context.getBean("single",Singleton.class);
		System.out.println("singleton : " + single);
	
		Singleton single2 = context.getBean("single",Singleton.class);
		System.out.println("singleton : " + single2);
		
	}

}
