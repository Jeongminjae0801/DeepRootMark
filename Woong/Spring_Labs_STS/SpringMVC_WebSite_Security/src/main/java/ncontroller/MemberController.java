package ncontroller;

import java.security.Principal;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private SqlSession session;	//org.mybatis.spring.SqlSessionTemplate 객체의 주소값이 Injection
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="/confirm.htm", method=RequestMethod.GET)
	public String memberPage() {
		return "member.memberConfirm"; //Tiles 적용하기
	}

	@RequestMapping(value="/confirm.htm", method=RequestMethod.POST)
	public String memberConfirm(String password, Principal principal, Model model) {
		MemberDao memberdao = session.getMapper(MemberDao.class);
		String path = "member.memberConfirm";

		try {
			Member user = memberdao.getMember(principal.getName());
			model.addAttribute("member", user);
			String encodedPassword = user.getPwd();
			
			if( bCryptPasswordEncoder.matches(password, encodedPassword) ){
				path="redirect:memberEdit.htm";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return path; //Tiles 적용하기
	}
	
	@RequestMapping(value="/memberEdit.htm", method=RequestMethod.GET)
	public String memberEditPage(Principal principal, Model model) {
		MemberDao memberdao = session.getMapper(MemberDao.class);
		try {
			Member member = memberdao.getMember(principal.getName());
			model.addAttribute("member", member);
		} catch (Exception e) {
			
		} 
		return "member.memberUpdate"; //Tiles 적용하기
	}
	
	@RequestMapping(value="/memberEdit.htm", method=RequestMethod.POST)
	public String memberEditPage(Principal principal, Member member) {
		
		MemberDao memberdao = session.getMapper(MemberDao.class);
		try {
			Member updatemember = memberdao.getMember(principal.getName());	
			
			//암호화작업
			updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
			updatemember.setName(member.getName());
			updatemember.setCPhone(member.getCPhone());
			updatemember.setEmail(member.getEmail());
			
			memberdao.update(updatemember);
		} catch (Exception e) {
			
		}
		return "redirect:/index.htm";
	}
}
