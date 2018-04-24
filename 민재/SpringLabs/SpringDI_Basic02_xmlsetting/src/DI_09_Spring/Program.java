package DI_09_Spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {

		/*ProtocolHandlerFactory factory = new ProtocolHandlerFactory();
		
		Map<String , ProtocolHandler> map = new HashMap<>();
		map.put("res", new RssHandler());
		map.put("rest", new RestHandler());
		
		factory.setHandler(map);*/
	
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_09_Spring/DI_09.xml");
		
	}

}
