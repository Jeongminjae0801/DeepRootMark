package DI_Annotation_05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 이 클래스는 스프링 설정 파일로 사용할거야
/*
Configcontext 을 Spring 설정 파일로 사용할 것 이다
: 객체 생성과 주입을 처리 하겠다

[전 제 조 건] 두 개가 사용되어야 한다
@Configuration ----> 설정 파일 어노테이션
@Bean  ----> 객체 생성 어노테이션
 	>>> 함수 기반의 처리
	
 
 xml 파일이라면
 	<bean id="user" class="DI_.......">
 Java 파일에서는 함수를 생성해서 객체 주소를 리턴해준다
 
 */

@Configuration	// xml 파일이 된다
public class Configcontext {

	@Bean
	public User user(){
		return new User();
	}
	
	@Bean
	public User2 user2() {
		return new User2();
	}
	
}
