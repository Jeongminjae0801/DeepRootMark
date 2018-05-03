package DI_09_Spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*ProtocolHandlerFactory factory = new ProtocolHandlerFactory();
		
		Map<String, ProtocolHandler> handler = new HashMap<>();
		handler.put("rss", new RssHandler());
		handler.put("rest", new RestHandler());
		
		factory.setHandler(handler);*/
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_09_Spring/DI_09.xml");
		
	}
}
