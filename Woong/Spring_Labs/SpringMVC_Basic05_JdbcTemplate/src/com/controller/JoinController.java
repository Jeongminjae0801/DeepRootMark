package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.MemberDAO;

@Controller
public class JoinController {

	//DB 작업
	//인터페이스
	private MemberDAO memberdao; // 인터페이스 타입
	@Autowired
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}
	
	@RequestMapping(value="/join.do" , method=RequestMethod.GET)
	public String form() {
		return "joinForm";
	}
	
	@RequestMapping(value="/join.do" ,method=RequestMethod.POST)
	public String submit(@RequestParam(value="id",required=true) String id,
			             @RequestParam(value="name") String name,
						 @RequestParam(value="pwd") String pwd,
						 @RequestParam(value="email" ,defaultValue="a@a") String email,
						 @RequestParam(value="age" ,defaultValue="0") int age){
		
		String view = null;
		boolean joinresult = memberdao.memberInsert(id, name, pwd, email, age);
		
		if(joinresult) {
			view = "joinSuccess";
		}else {
			view = "joinForm";
		}
		return view;
	}
	
	
	
}
