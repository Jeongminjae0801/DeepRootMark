package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.dto.User;
import kr.or.kosta.service.SqlMapClient;

public class Program {

	public static void main(String[] args) {
		SqlSessionFactory sqlsession = SqlMapClient.getSqlSession();
		//sqlMapClient.getsqlsession().opensession()
		
		SqlSession session = sqlsession.openSession();
		User user = (User) session.selectOne("Emp.getone","SMITH");
		session.close();
	
	}
	
	
	

}
