package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
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
	private SqlSession sqlsession;
	//org.mybatis.spring.SqlSessionTemplate
	
	@RequestMapping("notice.htm")
	public String listBoard(@RequestParam(value="pg" , defaultValue="1") int pg,
								  @RequestParam(value="f", defaultValue="TITLE") String f,
								  @RequestParam(value="q", defaultValue="%%") String q
								  , Model model) throws ClassNotFoundException, SQLException {
		
		NoticeDao dao = sqlsession.getMapper(NoticeDao.class);
		List<Notice> list =  dao.getNotices(pg, f, q);
		
		model.addAttribute("list",list);
		return "customer.notice";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String detailBoard(String seq , Model model) throws ClassNotFoundException, SQLException {
		
		NoticeDao dao = sqlsession.getMapper(NoticeDao.class);
		Notice detail = dao.getNotice(seq);
		model.addAttribute("notice",detail);
		
		return "customer.noticeDetail";
	}
	
	@RequestMapping(value="noticeReg.htm" , method=RequestMethod.GET)
	public String writeBoard() {
		return "customer.noticeReg";
	}
	
	@RequestMapping(value="noticeReg.htm" , method=RequestMethod.POST)
	public String writeOkBoard(Notice notice, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		
		   System.out.println("다중 파일 업로드");
		   System.out.println("n :" + notice.getTitle());
		   System.out.println("n :" + notice.getContent());
		   System.out.println("n 업로드 개수 :" + notice.getFiles().size());
		   System.out.println("n :" + notice.getFiles().get(0).getName());
		   System.out.println("n :" + notice.getFiles().get(1).getName());
		   
		   List<CommonsMultipartFile> files = notice.getFiles();
		   List<String> filenames = new ArrayList<>(); //파일명 담아넣기 (DB Insert)
		   
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
		   notice.setFileSrc(filenames.get(0));
		   notice.setFileSrc2(filenames.get(1));
		   
		   NoticeDao dao = sqlsession.getMapper(NoticeDao.class);
		   dao.insert(notice);
		   
		   return "redirect:notice.htm";
	}
	
	@RequestMapping(value="noticeEdit.htm" , method=RequestMethod.GET)
	public String editBoard(String seq ,  Model model) throws ClassNotFoundException, SQLException {
		
		System.out.println("혹시 너가 들어오니 ");
		
		NoticeDao dao = sqlsession.getMapper(NoticeDao.class);
		Notice edit = dao.getNotice(seq);
		
		model.addAttribute("notice",edit);
		model.addAttribute("seq",seq);
		
		return "customer.noticeEdit";
		
	}
	
	@RequestMapping(value="noticeEdit.htm" , method=RequestMethod.POST)
	public String editOkBoard(Notice notice ,  Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException {
		System.out.println(notice.getSeq());
		System.out.println("seq 들어 오니");
		
		 List<CommonsMultipartFile> files = notice.getFiles();
		   List<String> filenames = new ArrayList<>(); //파일명 담아넣기 (DB Insert)
		   
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
		   notice.setFileSrc(filenames.get(0));
		   notice.setFileSrc2(filenames.get(1));
		   
		   NoticeDao dao = sqlsession.getMapper(NoticeDao.class);
		   
		   int result = dao.update(notice);
		   return "redirect:noticeDetail.htm?seq=" + notice.getSeq();
		
	}
	@RequestMapping("noticeDel.htm")
	public String delete(String seq) throws ClassNotFoundException, SQLException {
		
		NoticeDao dao = sqlsession.getMapper(NoticeDao.class);
		int result = dao.delete(seq);
		System.out.println("삭제되었니"+result);
		return "redirect:notice.htm";
		
	}
}
