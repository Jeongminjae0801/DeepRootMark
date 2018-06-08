package site.book.user.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.book.user.dao.UserDAO;

@Service
public class UserService {
	
	// 변수 Start
	
	// 태웅
	
	
	// 희준
	@Autowired
	private SqlSession sqlsession;
	
	// 명수
	
	
	// 변수 End
	
	// 함수 Start
	
	// 태웅
	
	
	// 희준
	
	// 전체 회원수 가져오기
	public int getAllUser() {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int row = 0;
		
		try {
			row = userDAO.allUser();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	// 신규 가입자수 가져오기
	public int getNewUser() {
		UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
		int row = 0;
		
		try {
			row = userDAO.newUser();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	
	// 명수
	
	
	// 함수 End
}
