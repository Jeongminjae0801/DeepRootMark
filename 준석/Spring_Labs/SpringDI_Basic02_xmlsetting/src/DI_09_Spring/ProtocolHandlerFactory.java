package DI_09_Spring;

import java.util.Map;

public class ProtocolHandlerFactory {
  private Map<String, ProtocolHandler> handlers;
  //Map(key, value)
public void setHandlers(Map<String, ProtocolHandler> handlers) {
	this.handlers = handlers;
	System.out.println("setter 주입 성공 :" + this.handlers);
	}

}
