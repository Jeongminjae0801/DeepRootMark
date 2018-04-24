package DI_05_Spring;

public class MyBean {

	public MyBean() {
		System.out.println("::Default 생성자::");
		
	}
	public MyBean(String name) {
		System.out.println("::Overloading : " + name);
	}
	
	
}
