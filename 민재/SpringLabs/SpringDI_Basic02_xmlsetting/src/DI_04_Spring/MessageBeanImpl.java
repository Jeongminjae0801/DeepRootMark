package DI_04_Spring;

public class MessageBeanImpl implements MessageBean{
	
	private String name;
	private String greeting;
	
	// name 멤버 필드 생성자를 통해서 초기화
	public MessageBeanImpl(String name) {
		this.name = name;	// 멤버 필드 초기화
	}

	// greeting 멤버 필드 setter 함수를 통해서 초기화
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() {
		System.out.println(this.name + " / " + this.greeting );
		
	}

}
