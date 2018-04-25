package DI_01;

public class HelloApp {

	public static void main(String[] args) {
		MessageBean messagebean = new MessageBean();
		messagebean.sayHello("minjae");

	}

}
/*
요구사항
	MessageBean 영문 버전과 한글버전 
	ex) hong -> hello hong
		hong -> 안녕 hong
	결과를 나누어서 출력
	인터페이스로 구현 되었으면 좋겠어요 ===> MessageBean을 2개 만들어라
	>>> MessageBean_kr
	>>> MessageBean_en
	>>> 위 두 개의 클래스는 같은 인터페이스를 구현
*/