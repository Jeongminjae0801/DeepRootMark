package kr.or.bit.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.bit.dao.EmpDao;

@Controller
public class EmpController {
	
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	@RequestMapping("/main.htm")
	public String allEmpList(Model model) {
		//System.out.println("sssssssssssssssssssssssssssssss");
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		model.addAttribute("list", dao.getEmpAllList()); 
		return "home.emp_table";
	}
	
	@RequestMapping("/insert.htm")
	public String insertEmp() {
		return "";
	}
	
	@RequestMapping("/update.htm")
	public String updateEmp() {
		return "";
	}
	
	@RequestMapping("/del.htm")
	public String deleteEmp() {
		return "";
	}
}
