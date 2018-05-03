package DI_02;

public class MessageBean_kr implements Message {
	@Override
	public void sayHello(String name) {
		System.out.println("안녕 " + name + " 만나서 반가워!!");
		
	}
}
