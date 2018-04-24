package DI_03_Spring;

public class MessageBean_eg implements Message {
	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name + " Nice to meet you!!");
	}
}
