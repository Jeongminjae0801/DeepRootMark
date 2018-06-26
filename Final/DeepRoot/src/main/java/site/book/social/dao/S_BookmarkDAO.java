package site.book.social.dao;

import java.sql.SQLException;

import site.book.team.dto.G_BookDTO;

public interface S_BookmarkDAO {
	// 민재
	// 그룹 북마크로 URL 하나 insert
	public int insertGroupBookmark(G_BookDTO gbook) throws ClassNotFoundException, SQLException;
	
	// 완료된 그룹 내 북마크로 추가하기
	
	
	
	//진수
}
