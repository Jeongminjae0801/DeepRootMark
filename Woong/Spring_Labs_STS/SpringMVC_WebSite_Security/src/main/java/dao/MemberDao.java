package dao;

import java.sql.SQLException;

import vo.Member;

public interface MemberDao {
	//회원정보 얻기
	public Member getMember(String userid) throws ClassNotFoundException, SQLException;
	
	//회원정보 얻기
	public String getMemberPwd(String userid) throws ClassNotFoundException, SQLException;
	
	//회원정보 수정
	public void update(Member member) throws ClassNotFoundException, SQLException;
	
	//회원가입
	public int insert(Member member) throws ClassNotFoundException, SQLException;

	//ROLE_USER
	public int insertRole(String userid) throws ClassNotFoundException, SQLException;
}
