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
import org.springframework.web.bind.annotation.RequestParam;

import dao.MemberDao;
import dao.NoticeDao;
import vo.Member;

@Controller
@RequestMapping("/mypage/")
public class mypage {
	
	@Autowired
	private SqlSession sqlsession;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="confirm.htm",method=RequestMethod.GET)
	public String confirm() {
		
		return "mypage.confirm"; //폴더명.파일명 <definition name="*.*"
		
	}
	
	@RequestMapping(value="confirm.htm",method=RequestMethod.POST)
	public String confirm(@RequestParam("password") String rawPassword,Principal principal) throws ClassNotFoundException, SQLException {
		
			String viewpage="";
			
			MemberDao memberdao =  sqlsession.getMapper(MemberDao.class);
			
			//회원정보
			Member member = memberdao.getMember(principal.getName());
			
			//DB에서 가져온 암호화된 문자열
			String encodedPassword = member.getPwd();
			
			System.out.println("rowPassword : "+rawPassword );
			System.out.println("encodepassword : " + encodedPassword);
			
			boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
			System.out.println("비번 맞아요");
			if(result){
				viewpage="redirect:modify.htm";
				
			}else{
				viewpage="redirect:confirm.htm";
			}
			
			return viewpage;
		}
		
		
	@RequestMapping(value="modify.htm", method=RequestMethod.GET)
	public String modify(Model model, Principal principal) throws ClassNotFoundException, SQLException{
		System.out.println("비번 맞아요");
		
		MemberDao memberdao =  sqlsession.getMapper(MemberDao.class);
		Member member = memberdao.getMember(principal.getName());
		
		model.addAttribute("member", member);
		return "mypage.modify";
	}
	
	@RequestMapping(value="modify.htm", method=RequestMethod.POST)
	public String modify(Member member , Model model, Principal principal) throws ClassNotFoundException, SQLException{
			
		MemberDao memberdao =  sqlsession.getMapper(MemberDao.class);
		Member updatemember = memberdao.getMember(principal.getName());
			
		updatemember.setName(member.getName());
		updatemember.setcPhone(member.getcPhone());
		updatemember.setEmail(member.getEmail());
		updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
		memberdao.update(updatemember);
		System.out.println("수정완료");
		
		return "redirect:/index.htm";
	
	}
	
	
}





