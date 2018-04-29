package ncontroller;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

	private NoticeDao noticedao;
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	//글 목록보기
	//Model model > 함수의 parameter 사용시 자동 객체 생성  > Spring ....
	//notices(@RequestParam(value="pg",defaultValue=1....
	//public String notices  > return 되는 문자열 : view 의 주소 (/notice/notice.jsp)
	/*
	notice.jsp 
	<c:forEach items="${list}" var="n">
	<tr>
		<td class="seq">${n.seq}</td>
		<td class="title"><a href="noticeDetail.htm?seq=${n.seq}">${n.title}</a></td>
		<td class="writer">${n.writer}</td>
		<td class="regdate">${n.regdate}</td>
		<td class="hit">${n.hit}</td>
	</tr>
	</c:forEach>
	*/
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
			list = noticedao.getNotices(page, field, query);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		//ModelAndView 객체 사용가능
		//return new ModelAndView
		
		//Model : 데이터 담기
		//return :view 주소 
		model.addAttribute("list", list); //View 단 페이지에 자동 forward (list 이름으로)
		
		return "notice.jsp";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {

		
		Notice notice=null;
		try {
			notice = noticedao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		model.addAttribute("notice", notice);
		
		return "noticeDetail.jsp";
	}
	
	//1. 글쓰기 화면 처리 함수(GET)
	@RequestMapping(path="noticeReg.htm", method=RequestMethod.GET)
	public String noticeReg() {
		return "noticeReg.jsp";
	}
	
	
	//2. 글쓰기 처리 함수(POST) : 파일 업로드 기능
	//public String noticeReg(Notice n, HttpServletRequest request)
	
	@RequestMapping(path="noticeReg.htm", method=RequestMethod.POST)
	public String noticeReg2(Notice n, HttpServletRequest request) throws Exception {
		System.out.println("글쓰기 저장");
		
		CommonsMultipartFile imagefile = n.getFile();
		
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		
		String fpath = path + "\\" + filename;
		
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(imagefile.getBytes());
		fs.close();
		
		n.setFileSrc(filename);
		
		noticedao.insert(n);
		
		return "redirect:notice.htm";
	}
	
	
	//3. 글 삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDelete(String seq) throws ClassNotFoundException, SQLException {
		
		noticedao.delete(seq);
		return "notice.htm";
	}
}
