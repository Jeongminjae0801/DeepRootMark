package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import vo.Member;

public class NewMemberDao implements MemberDao {

	private JdbcTemplate jdbctemplate;
	@Autowired
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	@Override
	public Member getMember(String userid) throws ClassNotFoundException, SQLException {
		
		List<Member> results = 
				jdbctemplate.query("select userid,pwd,name,gender,birth,is_lunar,cphone,email,habit,regdate from member where userid=? ", 
				new RowMapper<Member>() {
					
					//권장 방법은 아니고 : DTO (VO) memberfield  와  select column명이 맞지 않는 경우 ...
					@Override
					public Member mapRow(ResultSet rs, int rownum) throws SQLException {
						Member member = new Member(rs.getString("userid"), 
												   rs.getString("pwd"), 
												   rs.getString("name"), 
												   rs.getString("gender"),
												   rs.getString("birth"),
												   rs.getString("is_Lunar"), 
												   rs.getString("cPhone"), 
												   rs.getString("email"), 
												   rs.getString("habit"), 
												   rs.getDate("regDate"));
						return member;
					}
				} );
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	
	@Override
	public int insert(final Member member) throws ClassNotFoundException, SQLException {
		
		
		return this.jdbctemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="insert into member(userid,pwd,name,gender,birth,is_lunar,cphone,email,habit,regdate) values(?,?,?,?,?,?,?,?,?,sysdate)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, member.getUserid());
				pstmt.setString(2, member.getPwd());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getGender());
				pstmt.setString(5, member.getBirth());
				pstmt.setString(6, member.getIsLunar());
				pstmt.setString(7, member.getcPhone());
				pstmt.setString(8, member.getEmail());
				pstmt.setString(9, member.getHabit());
				
				return pstmt;
			}
		});
	}

	
}
