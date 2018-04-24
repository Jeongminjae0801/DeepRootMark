package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) { 
		/*
		NewRecordView view = new NewRecordView();
		NewRecord record = new NewRecord(100, 70, 80);
		
		view.setRecord(record);//객체 주입
		
		
		view.input();
		view.print();
		*/
		//위 코드로 했던 작업을 SpringFramework 에게 맡기고 ...
		//Spring IOC 안에 : 2개의 객체를 만들고 setter 주입하는 작업 xml 파일 통해서 ...
		
		//설정 파일 : DIConfig.xml (객체의 생성, 주입)
		//Spring 컨테이너를 생성하고 -> DIConfig.xml read (파싱) 해서 ->
		// 생성된 Spring 컨테이너 (IOC) 안에 ...
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml"); //xml 경로 써준다
		//위 코드가 실행되면 IOC 컨테이너(메모리공간)를 생성 -> DIConfig.xml 을 읽어서 > 객체생성, 의존 설정 하면 끝 > END
		
		//컨테이너에 들어있는것을 꺼낼때 getBean
		RecordView view = (RecordView)context.getBean("view");
		view.input();
		view.print();
		
	}

}
