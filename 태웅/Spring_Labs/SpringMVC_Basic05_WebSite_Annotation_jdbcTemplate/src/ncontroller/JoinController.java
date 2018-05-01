package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus")
public class JoinController {
	
	@Autowired //By Type
	private MemberDao memberdao;
	
	
	private JdbcTemplate jdbctemplate;
	@Autowired
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String login(Member member) {
		//회원가입 처리 .... NewMemberDao 
		return "redirect:/index.htm"; 
	}
	
	@RequestMapping(value="/join.htm",method=RequestMethod.GET)
	public String join() {
		return "join.jsp";
	}
	
	@RequestMapping(value="/join.htm",method=RequestMethod.POST)
	public String join(Member member) {
		//회원가입 처리 .... NewMemberDao 
		System.out.println(member.toString());
		try {
			memberdao.insert(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/index.htm"; 
	}
	
}
