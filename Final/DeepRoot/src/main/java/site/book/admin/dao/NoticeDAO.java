/*
 * @Project : DeepRoot
 * @FileName : NoticeDAO.java
 * @Date : 2018. 6. 5.
 * @Author : 김희준
*/


package site.book.admin.dao;

import java.sql.SQLException;
import java.util.List;

import site.book.admin.dto.NoticeDTO;

/**
 * @Class : NoticeDAO.java
 * @Date : 2018. 6. 8.
 * @Author : 김희준
 */
public interface NoticeDAO {
	
	// 공지사항 쓰기
	public int noticeReg(String ncontent) throws ClassNotFoundException, SQLException;
	
	// 공지사항 가져오기
	public List<NoticeDTO> selectAllNotices() throws ClassNotFoundException, SQLException;
	
	
}
