package ncontroller;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="join.htm",method=RequestMethod.GET)
	public String join() {
		//return "join.jsp";
		return "joinus.join"; //폴더명.파일명 <definition name="*.*"
	}
	
	@RequestMapping(value="join.htm",method=RequestMethod.POST)
	public String join(@Valid Member member,Errors error) {

		if(error.hasErrors()) {
			return "joinus.join";
		}
		
		try {
			MemberDao memberdao = sqlSession.getMapper(MemberDao.class);
			memberdao.insert(member);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return "redirect:/index.htm";  //수정하면 안됨  페이지 다시 요청
	}
	
	//로그인 페이지
	@RequestMapping(value="login.htm" , method=RequestMethod.GET)
	public String login() {
		//return "login.jsp";
		return "joinus.login"; //폴더명.파일명
	}
	
}





