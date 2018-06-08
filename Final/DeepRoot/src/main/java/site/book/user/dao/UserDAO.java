package site.book.user.dao;

import java.sql.SQLException;
import java.util.List;

import site.book.user.dto.UserDTO;

/**
 * @Class : UserDAO.java
 * @Date : 2018. 6. 5.
 * @Author : 김희준
 */
public interface UserDAO {
	
	// 태웅
	
	// 희준
	
	//전체 회원수
	public int allUser() throws ClassNotFoundException, SQLException;
	
	// 신규 가입자 수
	public int newUser() throws ClassNotFoundException, SQLException;
	
	// 명수
}
