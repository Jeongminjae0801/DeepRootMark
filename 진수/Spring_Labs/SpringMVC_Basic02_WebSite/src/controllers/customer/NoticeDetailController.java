package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

public class NoticeDetailController implements Controller{
	
	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String seq = request.getParameter("seq");
		
		//DB연동 ....getNotice() 함수
		Notice content = noticedao.getNotice(seq);
		
		//View 페이지 : noticeDetail.jsp
		ModelAndView mv = new ModelAndView();
		mv.addObject("notice", content);
		mv.setViewName("noticeDetail.jsp");
		
		
		return mv;
	}
	
	
	

}
