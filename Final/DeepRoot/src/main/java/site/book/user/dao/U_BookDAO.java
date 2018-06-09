/*
 * @Project : DeepRoot
 * @FileName : U_BookDAO.java
 * @Date : 2018. 6. 5.
 * @Author : 김희준
*/


package site.book.user.dao;

import java.util.List;

import site.book.user.dto.U_BookDTO;

public interface U_BookDAO {
	
	// 태웅
	
	
	// 희준
	
	
	// 명수
	public List<U_BookDTO> getCategoryList(String uid);

	public int insertRootFolder(int ubid, String uid);

	public int getMaxId();

	public int updateNodeText(int id, String text);

	public int addFolderOrUrl(U_BookDTO dto);

	public void deleteFolderOrUrl(String str);

	public int editUrl(U_BookDTO dto);

}
