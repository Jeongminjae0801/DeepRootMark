package ncontroller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
public class CustomerController2 {
	
	private NoticeDao noticedao;

	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	
	@RequestMapping("/customer/notice.htm")
	public ModelAndView listBoard(@RequestParam(value="pg" , defaultValue="1")  int page ,
            @RequestParam(value="f",defaultValue="TITLE") String field,
            @RequestParam(value="q", defaultValue="%%") String query) throws ClassNotFoundException, SQLException {
		
		List<Notice> list = noticedao.getNotices(page, field, query);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		
		return mv;
	}
	
	@RequestMapping("/customer/noticeDetail.htm")
	public ModelAndView insertBoard(String seq) throws ClassNotFoundException, SQLException {
		
		//DB 연동......getNotice() 함수
		Notice notice = noticedao.getNotice(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("notice", notice);
				
		//View 페이지 : noticeDetail.jsp
		mv.setViewName("noticeDetail.jsp");
				
		return mv;
	}
	
}
