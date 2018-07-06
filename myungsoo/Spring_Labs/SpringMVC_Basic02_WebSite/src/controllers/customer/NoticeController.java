package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

//게시판 목록 보기 (행위 , 업무 )
public class NoticeController implements Controller {
    
	 public NoticeController() {
		System.out.println("[ NoticeController ]");
	}
	
	// NoticeController    ,  NoticeDao  클래스간의 관계
	// NoticeController 는 NoticeDao 에 의존한다
	// NoticeDao 주소만 가지면 된다 (injection) 
	 
	//NoticeDao dao = new NoticeDao()
	//dao.getNotices()
	//객체의 생성 .... IOC  
	 
	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}



	//doGET , doPOST 라고 생각하고 ....
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
       //게시판 목록보기 (Table 생성 되어 있어요)
	   //[DB 연결 -> select -> data  가공] -> 화면구성 -> 응답	
	
	   //검색 처리
		String _page = request.getParameter("pg");
		String _field = request.getParameter("f");
		String _query = request.getParameter("q");
				
		System.out.println(_page + ", " + _field + ", " + _query);
				
				
		//게시판 검색 설정을 위한 기본 값 설정
		int page=1;
		String field="TITLE";
		String query="%%";
				
		//조건 조합
		if(_page != null && !_page.equals("")) {
			page = Integer.parseInt(_page);
		}
				
		if(_field != null && !_field.equals("")) {
			field = _field;
		}
				
		if(_query != null && !_query.equals("")) {
			query = _query;
		}

		//DAO 객체 생성 ... 함수 호출
		List<Notice> list = noticedao.getNotices(page, field, query);
		
		//SpringMVC (ModelAndView 객체) > 원래 : request.setAttribute("list",list)
		ModelAndView mv= new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("notice.jsp");
		
		
		
		return mv;
	}

}




