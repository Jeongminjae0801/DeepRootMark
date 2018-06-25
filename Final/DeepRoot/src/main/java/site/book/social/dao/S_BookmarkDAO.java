package site.book.social.dao;

import java.sql.SQLException;

import site.book.team.dto.G_BookDTO;

public interface S_BookmarkDAO {

	// 그룹 북마크로 URL 하나 insert
	public int insertGroupBookmark(G_BookDTO gbook) throws ClassNotFoundException, SQLException;
}
