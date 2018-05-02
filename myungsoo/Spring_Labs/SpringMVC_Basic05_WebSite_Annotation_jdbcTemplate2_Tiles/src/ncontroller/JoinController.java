package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;


@Controller

@RequestMapping("/joinus/")
public class JoinController {
	
	@Autowired
	private MemberDao memberdao;

	@RequestMapping(value="join.htm", method= RequestMethod.GET)
	public String join() {
		return "join.jsp";
	}
	
	@RequestMapping(value="join.htm", method = RequestMethod.POST)
	public String join(Member member) {

		System.out.println(member.toString());
		
		try {
			memberdao.insert(member);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/index.htm";
	}
	
	
}
