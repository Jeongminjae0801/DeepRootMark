package DI_09_Spring;

import java.util.Map;

public class ProtocolHandlerFactory {
	
	//Map(key, value)
	private Map<String, ProtocolHandler> handler;

	public void setHandler(Map<String, ProtocolHandler> handler) {
		this.handler = handler;
		System.out.println("setter 주입 성공: " + this.handler);
	}
	
}
