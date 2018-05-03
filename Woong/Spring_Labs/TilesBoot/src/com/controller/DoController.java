package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoController {

	@RequestMapping("/firstMenu.do")
	public String index(){
		System.out.println("인덱스");
		return "do.TileIndex";
	}
	
	@RequestMapping("/addMember.do")
	public String addMember(){
		return "do.addMember";
	}
	
	@RequestMapping("/Login.do")
	public String Login(){
		return "do.Login";
	}
	
	@RequestMapping("/index.do")
	public String main(){
		return "do.index";
	}
	
}
