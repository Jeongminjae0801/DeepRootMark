package DI_10_Spring;

import java.util.Properties;

public class BookClient {

	private Properties config;
	
	public void setConfig(Properties config) {
		this.config = config;
	}
	
	public void connect() {
		String server = config.getProperty("server");
		String timeout = config.getProperty("connection_timeout");
		
		System.out.println("server : " + server);
		System.out.println("timeout : " + timeout);
	}
}
