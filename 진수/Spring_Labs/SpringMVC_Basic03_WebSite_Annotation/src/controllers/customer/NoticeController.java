package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;

//게시판 목록 보기 (행위, 업무)

public class NoticeController implements Controller{

	public NoticeController() {
		System.out.println("[ NoticeController ] ^^");
	}
	
	// NoticeController, NoticeDao 두 클래스 간의 관계는
	// NoticeController는 NoticeDao에 의존한다 (NoticeController는 NoticeDao 를 필요로 하기에...)
	// NoticeDao 주소만 가지면 된다 (injection)
	
	// NoticeDao dao = new NoticeDao();
	// dao.getNotices();
	// 기존 객체의 생성 ... 등등 위처럼 처리하던것을 IOC 컨테이너 에게 맡긴다 (Spring 이기 때문에)
	
	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	
	
	//doGET, doPOST 라고 생각하고 아래 작업하면 됨...
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 게시판 목록보기 (이미 테이블이 생성 되어 있어요라는 가정하에)
		// 순서 : DB연결 -> select -> data 가공 -> 화면구성 -> 응답
		
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
		
		//SpringMVC (ModelAndView 객체) > 원래는 : request.setAttribute("list", list)
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		
		
		return mv;
	}

	
}
