/*
 * @Project : DeepRoot
 * @FileName : TeamController.java
 * @Date : 2018. 6. 5.
 * @Author : 김희준
*/


package site.book.team.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import site.book.team.dto.G_BookDTO;
import site.book.team.dto.TeamDTO;
import site.book.team.service.G_BookService;
import site.book.team.service.TeamService;
import site.book.user.dto.U_BookDTO;

@Controller
@RequestMapping("/team/")
public class TeamController {

	
	//변수 STRAT
	
	//명수
	@Autowired
	TeamService teamservice;
	
	@Autowired
    private View jsonview;
	

	
	
	//태웅
	
	@Autowired
	G_BookService gbookservice;
	
	
	
	
	
	//변수 END
	
	
	//함수 STRAT
	
	//명수
	// 완료 그룹 리스트
	@RequestMapping("getCompletedTeamList.do")
	public View getCompletedTeamList(String uid ,  Model model) {
		
		List<TeamDTO> teamlist = teamservice.getCompletedTeamList(uid);
		
		model.addAttribute("teamlist",teamlist);
		return jsonview;
	}
	
	@RequestMapping("getTeamList.do")
	public View getTeamList(HttpServletRequest req,  Model model) {
		HttpSession session = req.getSession();
		String uid = (String)session.getAttribute("info_userid");
		
		List<TeamDTO> teamlist = teamservice.getTeamList(uid);

		model.addAttribute("teamlist", teamlist);
		return jsonview;
	}
	
	@RequestMapping("deleteCompletedTeam.do")
	public View deleteCompletedTeam(String uid, Model model) {
		
		int result = teamservice.deleteCompletedTeam(uid);
		
		model.addAttribute("result", result);
		return jsonview;
	}
	

	
	//태웅
	//해당 유저의 진행중인 그룹의 카테고리만를 보내준다.
	@RequestMapping("getGroupCategoryList.do")	
	public View getGroupCategoryList(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
        String uid = (String)session.getAttribute("info_userid");

		List<G_BookDTO> list = gbookservice.getGroupCategoryList(uid);
		
		if(list.size() == 0) {
			JSONObject jsonobject = new JSONObject();
			
			// result[0] : max(ubid) +1 한 값
			// result[1] : 그룹에 카테고리가 없을 경우, 기본 카테고리를  생성해 결과 값

			int result = gbookservice.getMaxIDandInsertRootFolder(uid);
			
			//처음 가입한 유저일 경우 root폴더 생성해 준다.
			if(result > 0 ) {	
				jsonobject.put("id", result);
				jsonobject.put("parent", "#");
				jsonobject.put("text", "첫 카테고리");
				jsonobject.put("icon", "fa fa-folder");
				jsonobject.put("uid", uid);
				
				model.addAttribute(jsonobject);
			}
		}else {
			for(int i=0; i<list.size(); i++) {
				JSONObject jsonobject = new JSONObject();
				
				String parentid = String.valueOf(list.get(i).getPid());
				
				//parent category  or child category
				if(parentid.equals("0") || parentid.equals("")) {
					jsonobject.put("parent", "#");
				}else {
					jsonobject.put("parent", parentid);
				}
				//Folder favicon 추가 & jsTree Form (JSON data)
				jsonobject.put("icon", "fa fa-folder");	
				jsonobject.put("id", list.get(i).getGbid());
				jsonobject.put("text", list.get(i).getUrlname());
				jsonobject.put("uid",uid);
				
				model.addAttribute(jsonobject);
			}
		}
		
		return jsonview;
	}
	
	
	//함수 END
	
}
