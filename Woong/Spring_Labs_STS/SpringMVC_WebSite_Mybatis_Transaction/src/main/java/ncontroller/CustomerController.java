package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import service.CustomerService;
import vo.Notice;

// >/customer/notice.htm
// >/customer/noticeDetail.htm


@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q , Model model) {
		
		List<Notice> list = customerService.notices(pg, f, q);
		model.addAttribute("list", list);
		
		return "customer.notice";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice = customerService.noticeDetail(seq);
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
	public String noticeReg(Notice n, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
	   
		try {
			customerService.noticeReg(n, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return "redirect:notice.htm";
	}

	//글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
		customerService.noticeDel(seq);
		
		return "redirect:notice.htm"; 
	}
	
	//글수정하기 (수정하기 화면)
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.GET)	
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		Notice notice = customerService.noticeDetail(seq);
		model.addAttribute("notice", notice);

		return "customer.noticeEdit";
	}
	
	//글수정하기(수정 처리)
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.POST )
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		customerService.noticeEdit(n, request);
		
		return "redirect:noticeDetail.htm?seq=" + n.getSeq();
	}

	//파일 다운로드
	@RequestMapping("download.htm")
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response) throws IOException {
		customerService.download(p, f, request, response);
	}
}
