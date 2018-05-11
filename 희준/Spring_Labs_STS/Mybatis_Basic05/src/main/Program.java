package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.dto.User;
import kr.or.kosta.service.SqlMapClient;

public class Program {

	public static void main(String[] args) {
		SqlSessionFactory sqlsession = SqlMapClient.getSqlSession();
		//SqlMapClient.getSqlSession().openSession();
		
		SqlSession session = sqlsession.openSession();
		User user = (User)session.selectOne("Emp.getone", "SMITH");
		System.out.println(user.getEmpno());
		session.close();
	}
	
	
	

}
