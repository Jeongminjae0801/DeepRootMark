package site.book.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import site.book.user.dto.U_BookDTO;
import site.book.user.service.U_BookService;
//user/mycategory.do";
@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	U_BookService u_bookservice;
	
	@RequestMapping("mybookmark.do")
	public String mybookmark() {
		System.out.println("들어왔어용");
		return "kms.myCategory";
	}
	
	@RequestMapping("getCategoryList.do")	//해당 유저의 카테고리를 보내준다.
	public void getCategoryList(String uid , HttpServletResponse res) {
		
		uid = "user1@naver.com";	//USER ID 받는거 생각하고 함
		res.setCharacterEncoding("UTF-8");
		
		JSONArray jsonArray = new JSONArray();	
		HashMap<String, String> urlmap = new  HashMap();
		
		List<U_BookDTO> list = u_bookservice.getCategoryList(uid);
		
		if(list.size() ==0) {
			
			JSONObject jsonobject = new JSONObject();
			
			int ubid = u_bookservice.getmaxid();	// max(ubid) +1 한 값이다.
			int result = u_bookservice.insertRootFolder(ubid, uid);
			
			if(result ==1 ) {	//처음 가입한 유저일 경우 root폴더 생성해 준다.
				
				urlmap.put("href", "");
				jsonobject.put("id", ubid);
				jsonobject.put("parent", "#");
				jsonobject.put("text", "첫 카테고리");
				jsonobject.put("icon", "");
				jsonobject.put("uid", uid);
				
				jsonArray.put(jsonobject);
				
			}
		}else {
			
			for(int i =0;i<list.size();i++) {
				
				JSONObject jsonobject = new JSONObject();
				
				String parentid = String.valueOf(list.get(i).getPid());
				urlmap.put("href", list.get(i).getUrl());	//a_attr 에 href를 객체로 넣어야 한다.
				
				if(parentid.equals("0") || parentid.equals(""))
					jsonobject.put("parent", "#");
				else
					jsonobject.put("parent", parentid);
				
				jsonobject.put("id", list.get(i).getUbid());
				jsonobject.put("text", list.get(i).getUrlname());
				jsonobject.put("icon", "");	//favicon 추가
				jsonobject.put("a_attr", urlmap);
				jsonobject.put("uid",uid);
				jsonobject.put("sname", list.get(i).getSname());
				jsonobject.put("htag", list.get(i).getHtag());
				
				jsonArray.put(jsonobject);
				
			}
		}
		try {
			res.getWriter().println(jsonArray);
		}catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("updateNodeText.do")
	public void updateNodeText(int id, String text, HttpServletResponse res) {
		
		int result = u_bookservice.updateNodeText(id , text);
		System.out.println(id+text);
		
		try {
			res.getWriter().println(result);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	@RequestMapping("addFolderOrLink.do")
	public void addFolder(U_BookDTO dto , HttpServletResponse res) {
		
		int ubid = u_bookservice.getmaxid();	// max(ubid) +1 한 값이다.
		dto.setUbid(ubid);
			
		System.out.println(dto.toString());
		int result = u_bookservice.addFolderOrLink(dto);
		
		try {
			res.getWriter().println(ubid);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	@RequestMapping("deleteNode.do")
	public void deleNode(HttpServletRequest req) {
		System.out.println("ddd");
		System.out.println(req.getParameterValues("childs[]"));
		 String[] aStr = req.getParameterValues("childs[]");
		 for(String str : aStr){
	            System.out.println(str);
	        }
	}

}
