/*
 * @Project : DeepRoot
 * @FileName : TopService.java
 * @Date : 2018. 6. 14.
 * @Author : 김희준
 */

package site.book.social.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import site.book.social.dto.TopDTO;
import site.book.social.service.SurfingService;
import site.book.social.service.TopService;
import site.book.team.dto.S_TeamDTO;
import site.book.team.service.TeamService;
import site.book.user.dto.S_U_BookDTO;
import site.book.user.dto.U_BookDTO;
import site.book.user.service.U_BookService;

/**
 * @Class : SocialController.java
 * @Date : 2018. 6. 14.
 * @Author : 김희준
 */
@Controller
@RequestMapping("/social/")
public class SocialController {
	/* 민재 파라미터 */
	@Autowired
	private TopService top_service;
	
	/* 진수햄 파라미터 */
	@Autowired
	private U_BookService u_bookservice;
	@Autowired
	private TeamService teamservice;
	@Autowired
	private SurfingService surfingservice;
	
	
	/* 민재 & 진수 함수 */
	@RequestMapping("social.do")
	public String social(Model model) {
		
		List<TopDTO> u_top5 = top_service.getUTop5();
		model.addAttribute("u_top5", u_top5);
		
		List<TopDTO> g_top5 = top_service.getGTop5();
		model.addAttribute("g_top5", g_top5);
		
		List<TopDTO> a_top5 = top_service.getATop5();
		model.addAttribute("a_top5", a_top5);
		/*u_booklist start*/
		List<S_U_BookDTO> u_list= u_bookservice.getSocialBookmarkList();
		model.addAttribute("u_list",u_list);
		
		List<S_TeamDTO> g_list=teamservice.getSocialGroupList();
		model.addAttribute("g_list", g_list);
		
		return "social.social";
	}
	
	/*u_booklist end*/
	
	/*해당 회원 북마크 가져오기 start*/
	//해당 유저의 카테고리를 보내준다.
		@RequestMapping("getCategoryList.do")	
		public void getCategoryList(HttpServletRequest req , HttpServletResponse res, String uid) {
			
			res.setCharacterEncoding("UTF-8");
			
			HttpSession session = req.getSession();
	        
			JSONArray jsonArray = new JSONArray();	
			List<U_BookDTO> list = surfingservice.getCategoryList(uid);
			

			for(int i =0;i<list.size();i++) {
				
				JSONObject jsonobject = new JSONObject();
				
				String parentid = String.valueOf(list.get(i).getPid());
				
				if(parentid.equals("0") || parentid.equals(""))
					jsonobject.put("parent", "#");
				else
					jsonobject.put("parent", parentid);
				
				if(list.get(i).getUrl() == null)
					jsonobject.put("icon", "fa fa-folder");	//favicon 추가
				else {
					jsonobject.put("icon", "https://www.google.com/s2/favicons?domain="+list.get(i).getUrl());	//favicon 추가
				}
				jsonobject.put("id", list.get(i).getUbid());
				jsonobject.put("text", list.get(i).getUrlname());
				jsonobject.put("uid",uid);
				jsonobject.put("sname", list.get(i).getSname());
				jsonobject.put("htag", list.get(i).getHtag());
				
				jsonArray.put(jsonobject);
				
			}
			
			try {
				res.getWriter().println(jsonArray);
			}catch (JSONException | IOException e) {
				e.printStackTrace();
			}
		}
		/*해당 회원 북마크 가져오기 end*/
}
