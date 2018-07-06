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
	/*
	@Autowired //By Type
	private MemberDao memberdao;
	*/
	@Autowired
	private SqlSession session;	//org.mybatis.spring.SqlSessionTemplate 객체의 주소값이 Injection
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="join.htm",method=RequestMethod.GET)
	public String join() {
		return "joinus.join"; //폴더명.파일명 <definition name="*.*"
	}
	
	
	@RequestMapping(value="join.htm",method=RequestMethod.POST)
	public String join(Member member) {
		
		try {
			MemberDao memberdao = session.getMapper(MemberDao.class);
			member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
			System.out.println(member.getPwd());
			memberdao.insert(member);
			memberdao.insertRole(member.getUserid());
		} catch (Exception e) {
				e.printStackTrace();
		} 
		
		return "redirect:/index.htm";  //수정하면 안되면  페이지 다시 요청
	}
	
	//로그인 페이지
	@RequestMapping(value="login.htm" , method=RequestMethod.GET)
	public String login() {
		return "joinus.login"; //폴더명.파일명
	}
	
}





