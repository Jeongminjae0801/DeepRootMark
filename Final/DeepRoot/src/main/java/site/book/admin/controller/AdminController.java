/*
 * @Project : DeepRoot
 * @FileName : AdminController.java
 * @Date : 2018. 6. 7.
 * @Author : 김희준
*/


package site.book.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import site.book.admin.dto.A_BookDTO;
import site.book.admin.dto.A_CategoryDTO;
import site.book.admin.service.A_BookService;
import site.book.admin.service.A_CategoryService;
import site.book.team.dto.S_TeamDTO;
import site.book.team.service.G_BookService;
import site.book.team.service.TeamService;
import site.book.user.dto.S_U_BookDTO;
import site.book.user.dto.U_BookDTO;
import site.book.user.service.U_BookService;
import site.book.user.service.UserService;

/**
 * @Class : AdminController.java
 * @Date : 2018. 6. 7.
 * @Author : 김희준
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private A_CategoryService a_CategoryService;
	
	@Autowired
	private A_BookService a_BookService;
	
	@Autowired
	private G_BookService g_BookService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private U_BookService u_BookService;
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping("admin.do")
	public String admin(Model model) {
		System.out.println("관리자 메인 페이지");
		
		List<A_CategoryDTO> categoryList = a_CategoryService.getCategorys();
		model.addAttribute("categoryList", categoryList);
		
		List<A_BookDTO> bookList = a_BookService.getBooks();
		model.addAttribute("bookList", bookList);
		
		List<HashMap<String, String>> gCount = g_BookService.numOfBookByDate();
		model.addAttribute("gCount", gCount);
		
		List<HashMap<String, String>> uCount = u_BookService.numOfBookByDate();
		model.addAttribute("uCount", uCount);
		
		int allUser = userService.getAllUser();
		model.addAttribute("allUser", allUser);
		
		int newUser = userService.getNewUser();
		model.addAttribute("newUser", newUser);
		
		List<S_U_BookDTO> uBookList = u_BookService.getSocialBookmarkList();
		model.addAttribute("uBookList", uBookList);
		
		List<S_TeamDTO> sGroupList = teamService.getSocialGroupList();
		model.addAttribute("sGroupList", sGroupList);
		
		return "khj.admin";
	}
	
	
	@RequestMapping("addCategory.do")
	public String addCategory(A_CategoryDTO category) {
		System.out.println("관리자 카테고리 추가");
		System.out.println("관리자 카테고리\n" + category.toString());
		
		a_CategoryService.addCategory(category);
		
		return "redirect:admin.do";
		
	}
	
	@RequestMapping("updateCategory.do")
	public String updateCategory(A_CategoryDTO category) {
		System.out.println("관리자 카테고리 수정");
		System.out.println("관리자 카테고리\n" + category.toString());
		
		a_CategoryService.updateCategory(category);
		
		return "redirect:admin.do";
	}
	
	@RequestMapping("deleteCategory.do")
	public String deleteCategory(String acid) {
		System.out.println("관리자 카테고리 삭제");
		System.out.println("관리자 카테고리 번호: " + acid);
		
		a_CategoryService.deleteCategory(Integer.parseInt(acid));
		
		return "redirect:admin.do";
	}
	
	@RequestMapping("addBook.do")
	public String addBook(A_BookDTO book) {
		System.out.println("관리자 URL 추가");
		System.out.println("관리자 카테고리 \n" + book.toString());
		
		a_BookService.addBook(book);
		
		return "redirect:admin.do";
	}
	
	@RequestMapping("updateBook.do")
	public String updateBook(A_BookDTO book) {
		System.out.println("관리자 URL 수정");
		System.out.println("관리자 카테고리 \n" + book.toString());
		
		a_BookService.updateBook(book);
		
		return "redirect:admin.do";
	}
	
	@RequestMapping("deleteBook.do")
	public String deleteBook(String abid) {
		System.out.println("관리자 URL 삭제");
		System.out.println("관리자 카테고리  번호: " + abid);
		
		a_BookService.deleteBook(Integer.parseInt(abid));
		
		return "redirect:admin.do";
	}
	
	@RequestMapping("deleteSUBook.do")
	public String deleteSUBook(String ubid) {
		System.out.println("소셜 개인 URL 삭제");
		System.out.println("소셜 개인 URL 번호: " + ubid);
		
		u_BookService.deleteSocialBookmark(Integer.parseInt(ubid));
		
		return "redirect:admin.do";
	}
	
	@RequestMapping("deleteSGroup.do")
	public String deleteSGroup(String gid) {
		System.out.println("소셜 그룹 삭제");
		System.out.println("소셜 그룹 번호: " + gid);
		
		teamService.deleteSocialGroup(Integer.parseInt(gid));
		
		return "redirect:admin.do";
	}
}
