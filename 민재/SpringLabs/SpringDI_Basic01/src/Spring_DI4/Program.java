package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		//NewRecordView view = new NewRecordView(100, 70, 80); // DI 에서 구현
	/*	
		NewRecordView view = new NewRecordView();
		
		//필요하다면 
		NewRecord record = new NewRecord(100, 60 , 80);
		view.setRecord(record);
		
		view.input();
		view.print();*/
		// 위 코드로 작업했던 것을 SpringFramework 에게 맡긴다
		// 스프링이란 녀석은 IOC (컨테이너) 안에 2개의 객체를 만들고 setter로 주입하는
		// 작업을 xml 파일을 통해서 한다
		// 설정 파일 : DIConfig.xml (객체의 생성/주입)
		// Spring 컨테이너를 생성하고 -> DIConfig.xml를 read(파싱)하고 ->
		// 생성된 Spring 컨테이너 (IOC) 안에 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		//이 코드가 실행되면 IOC 컨테이너 생성 -> 이 안의 설정을 읽어서 xml 파일을 read해서
		// 컨테이너 안에 객체를 생성하고 의존을 설정하면 끄읏
		RecordView view = (RecordView)context.getBean("view");
		view.input();
		view.print();
		
	}
}