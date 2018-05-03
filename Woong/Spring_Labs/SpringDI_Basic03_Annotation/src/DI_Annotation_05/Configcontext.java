package DI_Annotation_05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
	'Configcontext'를 Spring 설정파일로 사용하겠다. (xml파일을 이걸로 대체하겠다)
	: 객체 생성과 주입을 처리하겠다.
	
	@Configuration(설정 파일)
	@Bean(객체 생성)
	(함수 기반의 처리)
	
	xml 파일 이라면,
	<bean id="user" class="DI_Annotation_05.User">
	<bean id="user2" class="DI_Annotation_05.User2">
	Java 파일에서는 함수를 생성해서 객체 주소 리턴하는 형태
	
*/

@Configuration	// xml 생성
public class Configcontext {
	
	@Bean
	public User user() {	//<bean id="user" class="DI_Annotation_05.User">
		return new User();
	}
	
	@Bean
	public User2 user2() {	//<bean id="user2" class="DI_Annotation_05.User2">
		return new User2();
	}
}
