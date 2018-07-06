package dao;

import java.sql.SQLException;

import vo.Member;

public interface MemberDao {
	//회원정보 얻기
	public Member getMember(String userid) throws ClassNotFoundException, SQLException;
	
	//회원가입
	public int insert(Member member) throws ClassNotFoundException, SQLException;
	
	public int update(Member member) throws ClassNotFoundException, SQLException;
	
	public int idcheck(String userid) throws ClassNotFoundException, SQLException;
}
