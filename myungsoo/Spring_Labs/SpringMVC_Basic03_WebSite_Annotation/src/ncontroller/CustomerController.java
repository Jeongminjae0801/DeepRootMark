package ncontroller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

	private NoticeDao noticedao;
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	@RequestMapping("notice.htm")
	public String listBoard(@RequestParam(value="pg" , defaultValue="1") int pg,
								  @RequestParam(value="f", defaultValue="TITLE") String f,
								  @RequestParam(value="q", defaultValue="%%") String q
								  , Model model) throws ClassNotFoundException, SQLException {
		
		List<Notice> list = noticedao.getNotices(pg, f, q);
		
		model.addAttribute("list",list);
		return "notice.jsp";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String detailBoard(String seq , Model model) throws ClassNotFoundException, SQLException {
		
		Notice detail = noticedao.getNotice(seq);
		model.addAttribute("notice",detail);
		
		return "noticeDetail.jsp";
	}
	
	@RequestMapping(value="noticeReg.htm" , method=RequestMethod.GET)
	public String writeBoard() {
		return "noticeReg.jsp";
	}
	
	@RequestMapping(value="noticeReg.htm" , method=RequestMethod.POST)
	public String writeOkBoard(Notice notice, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		CommonsMultipartFile imagefile = notice.getFile();
		
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		
		notice.setFileSrc(filename);
		
		String fpath = path + "\\" + filename;
		
		FileOutputStream fs = new FileOutputStream(fpath);
		fs.write(imagefile.getBytes());
		fs.close();
		
		noticedao.insert(notice);
				
		
		return "notice.htm";
	}
	
	@RequestMapping(value="noticeEdit.htm" , method=RequestMethod.GET)
	public String editBoard(String seq ,  Model model) throws ClassNotFoundException, SQLException {
		
		Notice edit = noticedao.getNotice(seq);
		model.addAttribute("notice",edit);
		
		return "noticeEdit.jsp";
		
	}
	
	@RequestMapping(value="noticeEdit.htm" , method=RequestMethod.POST)
	public String editOkBoard(Notice notice ,  Model model) throws ClassNotFoundException, SQLException {
		
		
		return "noticeEdit.jsp";
	}
	@RequestMapping("noticeDel.htm")
	public String delete(String seq) throws ClassNotFoundException, SQLException {
		int result = noticedao.delete(seq);
		System.out.println("삭제되었니"+result);
		return "notice.htm";
		
	}
}
