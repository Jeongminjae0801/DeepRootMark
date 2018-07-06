package ncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	@RequestMapping(value="join.htm", method=RequestMethod.GET)
	public String join() {
		return "join.jsp";
	}
	
	@RequestMapping(value="join.htm", method=RequestMethod.POST)
	public String join(Member member) {
		//회원가입 처리......... NewMemberDao
		return "redirect:/index.htm";
	}
}
