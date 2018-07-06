package ncontroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

/* 강사님 코드
@Controller
@RequestMapping("/customer/")
*/
@Controller
public class CustomerController{

	private NoticeDao noticedao;
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}	
	
	
	public CustomerController() {
		System.out.println("생성자 들옴?");
	}

	//글 목록 보기
	@RequestMapping("/customer/notice.htm")
	public ModelAndView noticelist(@RequestParam(value="pg", defaultValue="1") int _page,
			  					   @RequestParam(value="f", defaultValue="TITLE") String _field,
			  					   @RequestParam(value="q", defaultValue="%%") String _query) throws Exception {
			/*
			String _page = request.getParameter("pg");
			String _field = request.getParameter("f");
			String _query = request.getParameter("q");
			*/		
			System.out.println(_page + ", " + _field + ", " + _query);
					
	
			//DAO 객체 생성 ... 함수 호출
			List<Notice> list = noticedao.getNotices(_page, _field, _query);
			
			//SpringMVC (ModelAndView 객체) > 원래는 : request.setAttribute("list", list)
			ModelAndView mv = new ModelAndView();
			mv.addObject("list", list);
			mv.setViewName("notice.jsp");
			
			
			return mv;
	}
	
	/* 강사님 코드
	//글 목록보기
		//Model model > 함수의 parameter 사용시 자동 객체 생성  > Spring ....
		//notices(@RequestParam(value="pg",defaultValue=1....
		//public String notices  > return 되는 문자열 : view 의 주소 (/notice/notice.jsp)
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
		
		//notice.jsp 
		//<c:forEach items="${list}" var="n">
		//<tr>
		//	<td class="seq">${n.seq}</td>
		//	<td class="title"><a href="noticeDetail.htm?seq=${n.seq}">${n.title}</a></td>
		//	<td class="writer">${n.writer}</td>
		//	<td class="regdate">${n.regdate}</td>
		//	<td class="hit">${n.hit}</td>
		//</tr>
		//</c:forEach>
		
	*/
	
	
	
	
	
	//글 상세보기
	@RequestMapping("/customer/noticeDetail.htm")
	public ModelAndView noticedetail(@RequestParam("seq") String seq) throws Exception {

			//DB연동 ....getNotice() 함수
			Notice content = noticedao.getNotice(seq);
			
			//View 페이지 : noticeDetail.jsp
			ModelAndView mv = new ModelAndView();
			mv.addObject("notice", content);
			mv.setViewName("noticeDetail.jsp");
			
			
			return mv;
	}
	
	/* 강사님 코드
	//글 상세보기
		@RequestMapping("noticeDetail.htm")
		public String noticeDetail(String seq , Model model) { // 여기서의 Model은 Spring 내장 클래스, **파라미터에 Model model 이라 적어 놓으면 알아서 생성해줌 **
			
			Notice notice=null;
			try {
				notice = noticedao.getNotice(seq);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			model.addAttribute("notice", notice);
			
			return "noticeDetail.jsp";
		}
	*/
	
	
	
	
	
	
	
	
	
	
	//과제
	//1. 글쓰기 화면 처리 함수 (GET)
	
	//2. 글쓰기 처리 함수 (POST) : 파일 업로드 기능
	//public String noteiceReg(Notice n, HttpServletRequest request){}
	
	//3. 글삭제하기

}
