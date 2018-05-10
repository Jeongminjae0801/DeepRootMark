package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

// >/customer/notice.htm
// >/customer/noticeDetail.htm


@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	@Autowired
	private SqlSession session;	//org.mybatis.spring.SqlSessionTemplate 객체의 주소값이 Injection
	
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q , Model model) {
		
		int page=1;
		String field="TITLE";
		String query="%%";
				
		//조건 조합
		if(pg != null && !pg.equals("")) {
			page = Integer.parseInt(pg);
		}
				
		if(f != null && !f.equals("")) {
			field = f;
		}
				
		if(q != null && !q.equals("")) {
			query = q;
		}

		//DAO 객체 생성 ... 함수 호출
		List<Notice> list=null;
		try {
			//list = noticedao.getNotices(page, field, query);
			NoticeDao dao = session.getMapper(NoticeDao.class);
			list = dao.getNotices(page, field, query);
		}catch (Exception e) {
			e.printStackTrace();
		} 

		model.addAttribute("list", list); //View 단 페이지에 자동 forward (list 이름으로)
		
		//return "notice.jsp";
		return "customer.notice";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice=null;
		try {
			//notice = noticedao.getNotice(seq);
			NoticeDao dao = session.getMapper(NoticeDao.class);
			notice = dao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		model.addAttribute("notice", notice);

		return "customer.noticeDetail";
	}

	//글쓰기 화면 
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	public String noticeReg() {
			return "customer.noticeReg";
	}
	
	//글쓰기 (처리)
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n, HttpServletRequest request, Principal principal) throws IOException, ClassNotFoundException, SQLException {
																// 인증 객체 Injection
	   List<CommonsMultipartFile> files = n.getFiles();
	   List<String> filenames = new ArrayList<String>(); //파일명 담아넣기 (DB Insert)
	   
	   if(files != null && files.size() > 0) {
		   for(CommonsMultipartFile multifile : files) {
			    
			    String filename = multifile.getOriginalFilename();
			    String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;
		
				if(!filename.equals("")) { //파일 쓰기
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); //DB insert 파일명	
		   	}
	   	}
	   	//실 DB INSERT
	   	n.setFileSrc(filenames.get(0));
	   	n.setFileSrc2(filenames.get(1));
	   
		/*****************************************************************************
		 * security 처리 인증 사용자 정보 얻기 **************************************************/
		/*SecurityContext context = SecurityContextHolder.getContext();	// 설정에 대한 전체 정보
		Authentication auth = context.getAuthentication();	// 인증 관련
		UserDetails userinfo = (UserDetails)auth.getPrincipal();
		System.out.println(userinfo.getAuthorities());	// 권한 정보
		System.out.println(userinfo.getUsername());	//회원 ID (로그인한 정보)
		System.out.println(userinfo.getPassword());	
			
		n.setWriter(userinfo.getUsername());*/
		/*****************************************************************************/
	   	//구체적인 권한 정보를 알 필요가 없다면, 아래와 같이 제일 간단한 방법으로 할 수 있음
	   	n.setWriter(principal.getName());
	   
	   	NoticeDao dao = session.getMapper(NoticeDao.class);
	   	dao.insert(n);
	   	return "redirect:notice.htm";
	}

	//글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao dao = session.getMapper(NoticeDao.class);
		dao.delete(seq);
		System.out.println("seq : " + seq);
		return "redirect:notice.htm"; //location.href... 현재 (notice.htm 에 view  로 있어서 가능)
	}
	
	//글수정하기 (수정하기 화면)
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.GET)	
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		NoticeDao dao = session.getMapper(NoticeDao.class);
		Notice notice = dao.getNotice(seq);
		model.addAttribute("notice", notice);

		return "customer.noticeEdit";
	}
	
	//글수정하기(수정 처리)
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.POST )
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명 담아넣기 (DB Insert)

		if (files != null && files.size() > 0) {
			for (CommonsMultipartFile multifile : files) {

				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;

				if (!filename.equals("")) { // 파일 쓰기
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); // DB insert 파일명
			}
		}
		// 실 DB INSERT
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));

		NoticeDao dao = session.getMapper(NoticeDao.class);
		dao.update(n);
		return "redirect:noticeDetail.htm?seq=" + n.getSeq();
	}

}
