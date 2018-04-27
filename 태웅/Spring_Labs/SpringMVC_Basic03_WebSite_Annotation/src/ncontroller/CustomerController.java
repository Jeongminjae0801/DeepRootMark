package ncontroller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private NoticeDao noticedao;
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	public CustomerController() {
		System.out.println("[ CustomerController ]");
	}
	
	@RequestMapping("/notice.htm")
	public ModelAndView notice( @RequestParam(value="pg", defaultValue="1") String page,
								@RequestParam(value="f", defaultValue="TITLE") String field,
								@RequestParam(value="q", defaultValue="%%") String query) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		
		System.out.println(page + ", " + field + ", " + query);
		
		// DAO 객체 생성 ... 함수 호출
		List<Notice> list = noticedao.getNotices(Integer.parseInt(page), field, query);
		
		//Spring MVC (ModelAndView 객체) >> 원래: request.setAttribute("list", list)
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("notice.jsp");
		
		return mav;
	}
/*
 *  함수 파라미터에  Model model > 함수의 parameter 사용시 자동 객체 생성 ... (Spring Framework 자동으로 만들고 주소값 줌)
	public String notices(String pg , String f , String q , Model model) {
		
		int page=1;
		String field="TITLE";
		String query="%%";
				
		//조건 조합
		if(pg != null && !pg.equals("")) { page = Integer.parseInt(pg); }	
		if(f != null && !f.equals("")) { field = f; }	
		if(q != null && !q.equals("")) { query = q; }

		//DAO 객체 생성 ... 함수 호출
		List<Notice> list=null;
		try {
			list = noticedao.getNotices(page, field, query);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		//ModelAndView 객체 사용가능
		//Model 
		model.addAttribute("list", list); //View 단 페이지에 자동 forward (list 이름으로)
		
		return "notice.jsp";
	}
*/
	
	@RequestMapping("/noticeDetail.htm")
	public ModelAndView noticeDetail( String seq ) throws ClassNotFoundException, SQLException {

		//DB 연공... getNotice() 함수
		Notice notice = noticedao.getNotice(seq);
		
		//view Page : noticeDetail.jsp
		ModelAndView mav = new ModelAndView();
		mav.addObject("notice", notice);
		mav.setViewName("noticeDetail.jsp");
		
		return mav;
	}
	
	//1.글쓰기 화면 처리 함수(GET)
	@RequestMapping(path="/noticeReg.htm", method=RequestMethod.GET)
	public String noticeReg() {
		return "noticeReg.jsp";
	}
	
	//2.글쓰기 처리 함수(POST) : 파일 업로드 기능
	//public String noteiceReg(Notice n , HttpServletRequest request) {}
	@RequestMapping(path="/noticeReg.htm", method=RequestMethod.POST)
	public String noticeWrite(Notice notice, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		//System.out.println(notice);
		CommonsMultipartFile imagefile = notice.getFile();
		
		//[실 파일 업로드 ....]
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		
		String fpath = path + "\\" + filename;
		
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(imagefile.getBytes());
		fs.close();
		
		notice.setFileSrc(filename);
		noticedao.insert(notice);
		System.out.println("파일 등록 완료");
		
		return "redirect:notice.htm";
	}
	
	
	//3.글삭제하기 
	@RequestMapping("/noticeDel.htm")
	public String noticeDel( String seq ) throws ClassNotFoundException, SQLException {
		
		//DB 에서 해당글 삭제
		noticedao.delete(seq);
		System.out.println("해당 게시글 삭제 완료");
		return "redirect:notice.htm";
	}
	
}
