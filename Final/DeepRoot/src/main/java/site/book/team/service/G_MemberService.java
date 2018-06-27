/*
 * @Project : DeepRoot
 * @FileName : G_MemberService.java
 * @Date : 2018. 6. 5.
 * @Author : 김희준
*/


package site.book.team.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.book.team.dao.G_MemberDAO;
import site.book.team.dto.G_MemberDTO;

@Service
public class G_MemberService {
	
	@Autowired
	private SqlSession sqlsession;
	
	// 참여하고 있는 그룹 나가기
	public int leaveGroup(G_MemberDTO member) {
		G_MemberDAO g_MemberDAO = sqlsession.getMapper(G_MemberDAO.class);
		int row = 0;
		
		try {
			row = g_MemberDAO.leaveGroup(member);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	//준석
	//그룹원 리스트 가져오기
	public List<G_MemberDTO> selectGMemberlist(String gid){
		G_MemberDAO g_MemberDAO = sqlsession.getMapper(G_MemberDAO.class);
		List<G_MemberDTO> selectgmemberlist = null;
		
		try {
			selectgmemberlist = g_MemberDAO.selectGMemberlist(gid);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return selectgmemberlist;
		
		
	}
	
}
