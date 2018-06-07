/*
 * @Project : DeepRoot
 * @FileName : AdminController.java
 * @Date : 2018. 6. 7.
 * @Author : 김희준
*/


package site.book.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import site.book.admin.dto.A_CategoryDTO;
import site.book.admin.service.A_CategoryService;

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
	private View jsonview;
	
	@RequestMapping("admin.do")
	public String admin(Model model) {
		System.out.println("관리자 메인 페이지");
		
		List<A_CategoryDTO> list = a_CategoryService.getCategorys();
		model.addAttribute("categoryList", list);
		
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
}
