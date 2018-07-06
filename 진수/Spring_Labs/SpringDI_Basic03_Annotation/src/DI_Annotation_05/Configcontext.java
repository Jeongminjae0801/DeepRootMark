package DI_Annotation_05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 Configcontext을 Spring 설정 파일로 사용하겠다 (즉, xml 파일로 대체 하겠다)
  이를 위해선, 두가지 전제조건이 필요하다
 : 객체 생성과 주입을 처리 하겠다 ...
 
 @Configuration (설정파일 만듦)
 @bean (객체 생성) (함수 기반의 처리로 생성한다)
 				Java 파일에서는 함수를 생성해서 객체 주소 리턴하는 형태로 만든다
 
 xml 파일이라면
 <bean id="user" class="DI_Annotation_05.User">
 <bean id="user2" class="DI_Annotation_05.User2">
 
 */

@Configuration // xml 생성
public class Configcontext {
	
	@Bean
	public User user() { // <bean id="user" class="DI_Annotation_05.User">
		return new User();
	}
	
	@Bean
	public User2 user2() { // <bean id="user2" class="DI_Annotation_05.User2">
		return new User2();
	}
}
