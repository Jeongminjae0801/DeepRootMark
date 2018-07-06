package DI_07_Spring;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
	/*	ProtocolHandler handler = new ProtocolHandler();
		
		ArrayList<MyFilter> arraylist = new ArrayList<>();
		arraylist.add(new EncFilter());
		arraylist.add(new HeaderFilter());
		arraylist.add(new ZipFilter());
		
		handler.setFilters(arraylist);
		System.out.println(handler.filter_length());*/
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_07_Spring/DI_07.xml");
		
		ProtocolHandler handler = context.getBean("handler", ProtocolHandler.class);
		System.out.println(handler.filter_length());
	}

}
