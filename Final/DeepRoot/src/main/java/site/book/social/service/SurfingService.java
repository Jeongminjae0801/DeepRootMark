package site.book.social.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.book.social.dao.TopDAO;
import site.book.user.dto.S_U_BookDTO;
import site.book.user.dto.U_BookDTO;

/**
 * @Class : SufingService.java
 * @Date : 2018. 6. 22.
 * @Author : 정진수
 */

@Service
public class SurfingService {

	@Autowired
	private SqlSession sqlsession;
	
	//해당 회원 북마크 가져오기
	public List<U_BookDTO> getCategoryList(String uid) {
		
		TopDAO dao = sqlsession.getMapper(TopDAO.class);
		List<U_BookDTO> list = dao.getCategoryList(uid);
		
		return list;
	}
	
}
