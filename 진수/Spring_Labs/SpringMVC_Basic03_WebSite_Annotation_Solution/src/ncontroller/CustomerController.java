package ncontroller;

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

import dao.NoticeDao;
import vo.Notice;

// >/customer/notice.htm
// >/customer/noticeDetail.htm


@Controller
@RequestMapping("/customer/")
public class CustomerController {

	private NoticeDao noticedao;
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	//글 목록보기
	//Model model > 함수의 parameter 사용시 자동 객체 생성  > Spring ....
	//notices(@RequestParam(value="pg",defaultValue=1....
	//public String notices  > return 되는 문자열 : view 의 주소 (/notice/notice.jsp)
	/*
	notice.jsp 
	<c:forEach items="${list}" var="n">
	<tr>
		<td class="seq">${n.seq}</td>
		<td class="title"><a href="noticeDetail.htm?seq=${n.seq}">${n.title}</a></td>
		<td class="writer">${n.writer}</td>
		<td class="regdate">${n.regdate}</td>
		<td class="hit">${n.hit}</td>
	</tr>
	</c:forEach>
	*/
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
	
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice=null;
		try {
			notice = noticedao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		model.addAttribute("notice", notice);
		
		return "noticeDetail.jsp";
	}

	 //글쓰기 화면 
	//@RequestMapping(method=RequestMethod.GET)
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	public String noticeReg() {
			return "noticeReg.jsp";
		}
	//글쓰기 (처리)
		//@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
		//public int insert(Notice n) ...
		//customer/upload 업로드 경로
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
				return "redirect:notice.htm"; //location.href... 현재 (notice.htm 에 view  로 있어서 가능)
			}

	    //요청 주소가 같아요 (GET , POST)
	    //글수정하기(두가지 처리 : GET >> 화면(select) , POST >> 처리(update))
		
		//글수정하기 (수정하기 화면)
		//함수 안에  void add(Model model) > 데이터 담아서 forward 할려고 함 .....
		@RequestMapping(value="noticeEdit.htm",method=RequestMethod.GET)	
		public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
			  //getNotice
			  //결과 model 객체에 담고
			 Notice notice =  noticedao.getNotice(seq);
			 model.addAttribute("notice", notice);
			 
			 return "noticeEdit.jsp"; //forward 
		  }
		
		//글수정하기(수정 처리)
		@RequestMapping(value="noticeEdit.htm",method=RequestMethod.POST )
		public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
			  //update
			  //fileupload
			    String filename = n.getFile().getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				
				String fpath = path + "\\" + filename;
				FileOutputStream fs = new FileOutputStream(fpath);
				fs.write(n.getFile().getBytes());
				fs.close();
				
				//파일명 추가/////////////
				n.setFileSrc(filename);
				///////////////////////
				noticedao.update(n);
				
				
			  return "redirect:noticeDetail.htm?seq="+n.getSeq();
		  }

	}