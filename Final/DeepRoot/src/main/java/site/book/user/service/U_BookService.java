/*
 * @Project : DeepRoot
 * @FileName : U_BookService.java
 * @Date : 2018. 6. 5.
 * @Author : 김희준
*/


package site.book.user.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.book.user.dao.U_BookDAO;
import site.book.user.dto.U_BookDTO;

@Service
public class U_BookService {
	
	@Autowired
	private SqlSession sqlsession;

	public List<U_BookDTO> getCategoryList(String uid) {	//해당
		
		U_BookDAO dao = sqlsession.getMapper(U_BookDAO.class);
		List<U_BookDTO> list = dao.getCategoryList(uid);
		
		return list;
	}

	public int insertRootFolder(int ubid, String uid) {
		
		U_BookDAO dao = sqlsession.getMapper(U_BookDAO.class);
		int result = dao.insertRootFolder(ubid, uid);
		
		return 0;
	}

	public int getmaxid() {

		U_BookDAO dao = sqlsession.getMapper(U_BookDAO.class);
		int maxid = dao.getMaxId();
		
		return maxid;
	}

}
