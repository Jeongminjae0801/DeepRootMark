package kr.or.kosta.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 #스코프와 생명주기
스코프와 생명주기에 대해서 이해하는것은 매우 중요하며 스코프와 생명주기를 잘못 사용하는 것은 다양한 문제를 발생 시킬 수 있다.

#SqlSessionFactoryBuilder
 이 클래스는 인스턴스화사용되고 버려지는 클래스이다. 
 그러므로 SqlSessionFactory를 생성한 후 유지할 필요는 없게된다.
 따라서 SqlSessionFactoryBuilder 인스턴스의 가장 좋은 스코프는 메서드 스코프(메서드내 지역변수)이다. 
 여러개의 SqlSessionFactory인스턴스를 빌드하기 위해 SqlSessionFactoryBuilder를 재사용 할 수도 있지만
 유지하지 않는것이 가장 좋다.

#SqlSessionFactory
 SqlSessionFactory는 애플리케이션을 실행하는 동안 존재해야만한다. 
 따라서 삭제하거나 재생성할 필요가 없다. 
 애플리케이션이 실행되는 동안 여러차례 SqlSessionFactory를 다시 빌드하지 않는것이 가장 좋은 형태이며, 
 재빌드하는 형태는 결과적으로 문제를 발생시킬 수 있는 좋지않은 형태이다
 .그렇기 때문에 SqlSessionFactory의 가장 좋은 스코프는 애플리케이션 스코프 이며, 
 애플리케이션 스코프로 유지하기 위한 다양한 방법이 존재한다. 
 가장 간단한 방법은 싱글턴 패턴이나 static 싱글턴 패턴을 사용하는 것이다.

#SqlSession
 각각의 쓰레드는 자체적으로 SqlSession 인스턴스를 가져야 한다.
 SqlSession인스턴스는 공유되지 않고 쓰레드내에서도 안전하지도 않다. 
 그러므로 가장 좋은 스코프는 요청 또는 메서드 스코프이다. 
 또한 SqlSession은 요청처리후 닫아주는것이 매우 중요한 부분이며, 
 언제나 finally블록을 사용하여 닫아야 한다.

#Mapper 인스턴스
  mapper는 매핑된 구문을 바인딩 하기 위해 만들어야할 인터페이스 이다. mapper 인터페이스의 인스턴 
 */
/*
 * 안좋은 형식의 코드 패턴
public class SqlMapClient {
	private static SqlSession session;
	static {
		String resource = "SqlMapConfig.xml";
		try {
			 Reader reader = Resources.getResourceAsReader(resource);
			 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			 session = factory.openSession();
		}catch(Exception e) {
			
		}
		
	 
	}
	 public static SqlSession getSqlSession(){
		  return session;
	  }	
}
*/
public class SqlMapClient {
	private static SqlSessionFactory sqlsessionfactory;
	static {
		String resource = "SqlMapConfig.xml";
		try {
			 Reader reader = Resources.getResourceAsReader(resource);
			 sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
			 
		}catch(Exception e) {
			
		}
 
	}
	 public static SqlSessionFactory getSqlSession(){
		  return sqlsessionfactory;
	  }	
}

