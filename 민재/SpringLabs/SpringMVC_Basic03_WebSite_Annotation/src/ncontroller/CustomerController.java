package ncontroller;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

// CustomerController 하나로 함수 단위로 처리
@Controller
public class CustomerController {

	private NoticeDao noticedao;
		
	public void setNoticedao(NoticeDao noticedao) {
		 this.noticedao = noticedao;
	 }
	public CustomerController() {
		System.out.println("ㅎㅇ?");
	}
	
	// 글 목록보기
	// Model model -> 함수의 파라미터 사용 시 자동으로 객체를 생성해줄게 -> Spring이 알아서 ..
	
	@RequestMapping("/customer/notice.htm")
	public ModelAndView listBoard(@RequestParam(value="pg" , defaultValue="1") String page,
								  @RequestParam(value="f" , defaultValue="TITLE") String field,
								  @RequestParam(value="q", defaultValue="%%") String query) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		List<Notice> list = noticedao.getNotices(Integer.parseInt(page), field, query);
		
		//model == 데이터 담기
		//model.addAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		
		//return == view 주소
		return mv;
	}
	
	@RequestMapping("/customer/noticeDetail.htm")
	public ModelAndView listDetailBoard(@RequestParam(value="seq") String seq) throws ClassNotFoundException, SQLException {
		Notice n = noticedao.getNotice(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("notice", n);
		mv.setViewName("noticeDetail.jsp");
		
		return mv;
	}
	 
	// 1. 글쓰기 화면 처리 함수 (GET)
	@RequestMapping(value="/customer/noticeReg.htm",
					method=RequestMethod.GET)
	public String insertBoard() {

		return "noticeReg.htm";
	}
	
	// 2. 글쓰기 처리 함수 (POST) : 파일 업로드 기능
	/*@RequestMapping(value="noticeDetail.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n , HttpServletRequest request) {
		
		
		return null;
	}*/
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
			
			String filename = n.getFile().getOriginalFilename();
			String path = request.getServletContext().getRealPath("/customer/upload");
			
			String fpath = path + "\\" + filename;
			FileOutputStream fs = new FileOutputStream(fpath);
			fs.write(n.getFile().getBytes());
			fs.close();
			
			//파일명 추가/////////////
			n.setFileSrc(filename);
			///////////////////////
			noticedao.insert(n);
			
			
			//return "notice.htm";
			return "redirect:notice.htm";//redirect:
		    
			//주소창 주소 확인하기
			//return "redirect:notice.htm";
			//http://localhost:8090/SpringMVC_Basic05_WebSite_Annotation/customer/notice.htm
			//F5 , 새로고침 처리 목록페이지 보여주도록 설정
			
			//location.href
			//response.sendredirect
			
			
			// POINT-1***********************************************
			// public String noticeReg(Notice n , HttpServletRequest request)
			// Parameter > Notice n 객체 타입
			// 글쓰기 화면 입력 > 함수(입력한 값)
			// 전제 : <input 태그 name="" 값하고 Notice 객체가 가지는 memberField명 같은 경우
			 
			// POINT-2***********************************************
			// Spring 에서 파일 업로드
			// 웹 서버 upload 폴더 : 파일올리기 (IO)
			// DB : 파일명만 가지면 된다
			
			//<Form 태그에 속성으로 : enctype="multipart/form-data">
			// 1.의존 lib 추가 (fileupload , io)
		    // 2. VO , DTO 쪽에Spring 제공하는
			// CommonsMultipartFile 타입을 갖는 멤버 변수 추가하기 (setter, getter)
			 
			// 3. 전송페이지에서 <form ... enctype="multipart/form-data" 설정
			// -<input type="file" name="file" 파일명 VO 객체 이름 동일 강제사항
			 
			// 4. xml container 에
			// ***CommonsMultipartFile 반드시> id="multipartResolver"***
			//<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" >
			//   <property name="maxUploadSize" value="10485760"/>
			//</bean>
		}

	  //글삭제하기
		@RequestMapping("noticeDel.htm")
		public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
			
			noticedao.delete(seq);
			System.out.println("seq : " + seq);
			return "redirect:notice.htm"; //location.href...
		}
	
	
}
