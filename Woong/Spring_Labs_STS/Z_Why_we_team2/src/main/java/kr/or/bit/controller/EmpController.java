package kr.or.bit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.EmpDto;

@Controller
public class EmpController {
	
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	@RequestMapping("/main.htm")
	public String allEmpList(Model model) {
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		model.addAttribute("list", dao.getEmpAllList()); 
		return "home.emp_table";
	}
	
	@RequestMapping(value="/insert.htm", method=RequestMethod.GET)
	public String insertEmp() {
		return "emp.emp_insert";
	}
	@RequestMapping(value="/insert.htm", method=RequestMethod.POST)
	public String insertEmp(EmpDto empdto) {
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		dao.insertEmp(empdto);
		return "redirect:/main.htm";
	}
	
	@RequestMapping(value="/update.htm", method=RequestMethod.GET)
	public String updateEmp(String empno, Model model) {
		Map<String, Integer> emp = new HashMap<>();
		emp.put("empno", Integer.parseInt(empno));
		
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		EmpDto dto = dao.getEmpAllList(emp);
	
		model.addAttribute("emp", dto);
		return "emp.emp_update";
	}
	@RequestMapping(value="/update.htm", method=RequestMethod.POST)
	public String updateEmp(EmpDto empdto) {
		System.out.println(empdto);
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		empdto.setHiredate(empdto.getHiredate().split(" ")[0]);
		System.out.println(dao);
		dao.updateEmp(empdto);
		return "redirect:/main.htm";
	}
	
	@RequestMapping("/del.htm")
	public String deleteEmp(String empno) {
		
		EmpDao dao = sqlsession.getMapper(EmpDao.class);
		
		
		dao.deleteEmp(Integer.parseInt(empno));
		return "redirect:/main.htm";
	}
}
