package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeDetailController implements Controller {

	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String seq = request.getParameter("seq");
		
		
		
		
		//db 연동 ..getnotice() 함수
		
		Notice detail = noticedao.getNotice(seq);
		
		//view noticedetail.jsp
		ModelAndView mv = new ModelAndView();
		mv.addObject("notice",detail);
		mv.setViewName("noticeDetail.jsp");
		
		return mv;
	}

}
