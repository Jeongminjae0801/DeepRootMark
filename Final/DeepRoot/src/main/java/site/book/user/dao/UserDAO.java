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
	
	//전체 회원
	public List<UserDTO> selectAllUser() throws ClassNotFoundException, SQLException;
	
	//회원 1명
	public UserDTO selectUser(String uid) throws ClassNotFoundException, SQLException;
	
	//회원 가입
	public int insertUser(UserDTO userdto) throws ClassNotFoundException, SQLException;
	
	//회원 수정
	public int updateUser(UserDTO userdto) throws ClassNotFoundException, SQLException;
	
	//회원 삭제
	public int deleteUser(String uid) throws ClassNotFoundException, SQLException;
	
	// 명수
}
