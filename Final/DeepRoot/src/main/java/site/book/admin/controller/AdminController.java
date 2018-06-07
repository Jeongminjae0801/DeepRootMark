/*
 * @Project : DeepRoot
 * @FileName : AdminController.java
 * @Date : 2018. 6. 7.
 * @Author : 김희준
*/


package site.book.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	@RequestMapping("admin.do")
	public String admin() {
		return "khj.admin";
	}
	
	
	@RequestMapping("addCategory.do")
	public String addCategory(A_CategoryDTO category) {
		System.out.println("관리자 카테고리 추가");
		System.out.println("관리자 카테고리\n" + category.toString());
		
		a_CategoryService.addCategory(category);
		
		return null;
		
	}
	
}
