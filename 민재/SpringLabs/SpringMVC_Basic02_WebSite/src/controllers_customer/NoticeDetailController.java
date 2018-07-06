package controllers_customer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;


public class NoticeDetailController implements Controller{

	private NoticeDao noticedao;
	
	 public NoticeDetailController() {
			System.out.println("[ NoticeDetailController ]");
		}

	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String seq = request.getParameter("seq");	//db에서 seq 받아온다
		
		// db 연동 -> getNotice() 함수
	
		Notice n = noticedao.getNotice(seq);
		
		// view 페이지 : noticeDetail.jsp
		ModelAndView mv = new ModelAndView();
		mv.addObject("notice", n);
		mv.setViewName("noticeDetail.jsp");
		
		return mv;
	}

}
