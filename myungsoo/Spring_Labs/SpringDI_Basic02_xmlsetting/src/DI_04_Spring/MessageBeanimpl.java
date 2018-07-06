package DI_04_Spring;

public class MessageBeanimpl implements MessageBean{
	
	private String name;
	private String greeting;
	
	//name member field 생성자를 통해서 초기화	
	public MessageBeanimpl(String name) {
		this.name = name; //memeber field 초기화
	}
	
	//greeting member field 는 setter 함수를 통해서 초기화
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() {
		System.out.println(this.name +"/" + this.greeting);
	
	}


}
