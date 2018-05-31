package ncontroller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	@Autowired
	private SqlSession sqlsession;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="join.htm",method=RequestMethod.GET)
	public String join() {
		//return "join.jsp";
		return "joinus.join"; //폴더명.파일명 <definition name="*.*"
	}
	
	@RequestMapping(value="join.htm",method=RequestMethod.POST)
	public String join(Member member) {
		
		member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
		
		try {
			
			MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
					memberdao.insert(member);
				
		} catch (Exception e) {
				e.printStackTrace();
		} 
		
		return "redirect:/index.htm";  //수정하면 안되면  페이지 다시 요청
	}
	
	//로그인 페이지
	@RequestMapping(value="login.htm" , method=RequestMethod.GET)
	public String login() {
		//return "login.jsp";
		return "joinus.login"; //폴더명.파일명
	}
	
}





