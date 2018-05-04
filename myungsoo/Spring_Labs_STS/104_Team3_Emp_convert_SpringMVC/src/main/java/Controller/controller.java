package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.EmpDaoI;
import dto.EmpDto;

@Controller
public class controller {
	
	@Autowired
	private SqlSession sqlsession;

	@RequestMapping("/home.htm")
	public String home(Model model) {
		System.out.println("indexcontroller");
		//return "index.jsp";
		EmpDaoI boardDao = sqlsession.getMapper(EmpDaoI.class);
		ArrayList<EmpDto> list = boardDao.getEmpAllList();
		
		model.addAttribute("list",list);
		System.out.println(list);
		return "home.3group_table";
	}
	
	@RequestMapping(value="/addemp.htm" , method=RequestMethod.GET)
	public String addemp() {
		
		System.out.println("addemp get");
		
		return "add.emp";
		
	}
	
	@RequestMapping(value="/addemp.htm" , method=RequestMethod.POST)
	public String addemp(@RequestParam HashMap<String, String> param) {
		
		System.out.println(param);
		System.out.println("addemp insert");
		EmpDaoI boardDao = sqlsession.getMapper(EmpDaoI.class);
		boardDao.insertEmp(param);
		
		return "redirect:/home.htm";
		
	}
	
	@RequestMapping("/del.htm")
	public String delemp(@RequestParam HashMap<String, String> param) {
		System.out.println(param);
		System.out.println("delemp insert");
		EmpDaoI boardDao = sqlsession.getMapper(EmpDaoI.class);
		boardDao.deletEmp(param);
		
		return "redirect:/home.htm";
		
	}
	
	

}
