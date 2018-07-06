package DI_01;

public class HelloApp {
	
	public static void main(String[] args) {
		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("hong");
	}

}

/*
	요구사항
	messagebean
	영문버전(hong) -> Hellod hong
	한글버전 (hong) -> 안녕 ㅙㅜㅎ
	결과를 나누어서 출력
	인터페이스를 구현 되었으면..
	
	>messagebean_kr
	>messagebean_en
	>위 두개 클래스는 같은 interface를 구현...

	
*/