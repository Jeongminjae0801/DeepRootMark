package main;

import org.apache.ibatis.session.SqlSession; 
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.dto.User;
import kr.or.kosta.service.SqlMapClient;

public class Program {

	public static void main(String[] args) {
		
		SqlSessionFactory sqlsession = SqlMapClient.getSqlSession();
		/*SqlMapClient.getSqlSession().openSession();*/
		
		SqlSession session = sqlsession.openSession(); // session 객체를 얻음 (인터페이스)
		System.out.println(session);
		
		User user = (User) session.selectOne("Emp.getone", "KING");	// (1) 함수 이름 , (2) 파라미터 이름
		
		System.out.println(user.getEmpno());
		session.close();
		
	}
	
	
	

}
