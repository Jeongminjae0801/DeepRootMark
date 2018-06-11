package site.book.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import site.book.user.dto.U_BookDTO;
import site.book.user.dto.UserDTO;
import site.book.user.service.U_BookService;
import site.book.user.service.UserService;
//user/mycategory.do";
@Controller
@RequestMapping("/user/")
public class UserController {
	
	// 변수 Start
	
	// 태웅
	@Autowired
    private View jsonview;
	
	@Autowired
	private UserService userservice;
	// 희준
	
	
	// 명수
	@Autowired
	U_BookService u_bookservice;
	
	// 변수 End
	
	// 함수 Start
	
	// 태웅
	@RequestMapping(value="idcheck.do", method = RequestMethod.POST)
	public View userIdCheck(@RequestParam("uid") String uid, Model model) {
		//System.out.println(uid);
		int result = userservice.checkUserID(uid);
		if(result > 0) {
			model.addAttribute("result", "fail");
		}else {
			model.addAttribute("result", "pass");
		}
		
		return jsonview;
	}
	
	@RequestMapping(value="nnamecheck.do", method = RequestMethod.POST)
	public View userNnameCheck(@RequestParam("nname") String nname, Model model) {
		//System.out.println(nname);
		int result = userservice.checkUserNickname(nname);
		if(result > 0) {
			model.addAttribute("result", "fail");
		}else {
			model.addAttribute("result", "pass");
		}
		
		return jsonview;
	}
	// 희준
	
	
	// 명수
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
		
		List<U_BookDTO> list = u_bookservice.getCategoryList(uid);
		
		if(list.size() ==0) {
			
			JSONObject jsonobject = new JSONObject();
			
			int ubid = u_bookservice.getmaxid();	// max(ubid) +1 한 값이다.
			int result = u_bookservice.insertRootFolder(ubid, uid);
			
			if(result ==1 ) {	//처음 가입한 유저일 경우 root폴더 생성해 준다.
				
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
				
				if(parentid.equals("0") || parentid.equals(""))
					jsonobject.put("parent", "#");
				else
					jsonobject.put("parent", parentid);
				
				jsonobject.put("id", list.get(i).getUbid());
				jsonobject.put("text", list.get(i).getUrlname());
				jsonobject.put("icon", "");	//favicon 추가
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
	
	@RequestMapping("addFolderOrUrl.do")
	public void addFolder(U_BookDTO dto , HttpServletResponse res) {
		
		int ubid = u_bookservice.getmaxid();	// max(ubid) +1 한 값이다.
		dto.setUbid(ubid);
			
		System.out.println(dto.toString());
		int result = u_bookservice.addFolderOrUrl(dto);
		
		try {
			res.getWriter().println(ubid);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	@RequestMapping("deleteNode.do")
	public void deleNode(HttpServletRequest req , HttpServletResponse res) {
		res.setCharacterEncoding("UTF-8");
		//mysql에 cascade 햇기 때문에 url이든 폴더를 지우려고 하든 상위의 ubid를 보내부면 알아서 참조하는 모든 데이터가 삭제된다,.
		System.out.println("ddd");
	//	System.out.println(req.getParameterValues("childs[]"));
		/* String[] aStr = req.getParameterValues("childs[]");
		 for(String str : aStr){
	            System.out.println(str);
	            u_bookservice.deleteFolderOrUrl(str);
	        }*/
		String nodeid = req.getParameter("node");
		u_bookservice.deleteFolderOrUrl(nodeid);
		
		try {
			res.getWriter().println("success");
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	@RequestMapping("editUrl.do")
	public void editUrl(U_BookDTO dto , HttpServletResponse res) {
		
		res.setCharacterEncoding("UTF-8");
		
		int result = u_bookservice.editUrl(dto);
		
		try {
			res.getWriter().println(result);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
	
	// 함수 End
}
