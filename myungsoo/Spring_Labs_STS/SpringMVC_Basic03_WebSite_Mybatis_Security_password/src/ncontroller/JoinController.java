package ncontroller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
/*	
	@Autowired
	private View jsonview;*/

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
			System.out.println(member);
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
	
	@RequestMapping("idcheck.htm")
	public @ResponseBody String idcheck(String userid ) throws ClassNotFoundException, SQLException {
		System.out.println(userid);
		
		MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
		int result = memberdao.idcheck(userid);
		String end = "1";
		if(result==0) {
			end="0";
		}
		return end;
		
	}
	
}





