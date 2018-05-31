package ncontroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

// >/customer/notice.htm
// >/customer/noticeDetail.htm


@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
	private SqlSession sqlsession;
	//org.mybatis.spring.SqlSessionTemplate 객체의 주소값이 injection
	
	//글 목록보기
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
			//list = noticedao.getNotices(page, field, query);
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			list = noticedao.getNotices(page, field, query);

		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		model.addAttribute("list", list); //View 단 페이지에 자동 forward (list 이름으로)
		
		return "customer.notice";
	}
	
	//글 상세보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice=null;
		try {
			NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
			notice = noticedao.getNotice(seq);
			//notice = noticedao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		model.addAttribute("notice", notice);
		
		//return "noticeDetail.jsp";
		return "customer.noticeDetail";
	}

	//글쓰기 화면 
	//@RequestMapping(method=RequestMethod.GET)
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	public String noticeReg() {
			//return "noticeReg.jsp";
			return "customer.noticeReg";
		}
/*	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(@RequestParam("f") MultipartFile multipartfile, HttpServletRequest request , Principal principal) throws IOException, ClassNotFoundException, SQLException {
			if(!multipartfile.isEmpty()) {
			//1. copy는 바이트를 넣어야 한다.
				byte[] bytes = multipartfile.getBytes();
				File file = new File("/bbbb/", multipartfile.getOriginalFilename());
				FileCopyUtils.copy(bytes, file);
				multipartfile.transferTo(file);
				
			}
			 return "redirect:notice.htm";}*/
			@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
			public String noticeReg(MultipartHttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
									
				List<MultipartFile> files = request.getFiles("f"); 
			
				for(MultipartFile fileing : files) {
					File file = new File("/bbbb/", fileing.getOriginalFilename());
					fileing.transferTo(file);
				}
				
				
				//multiparthttpservletrequest 기능에 다중의 파일들을 list로 받을 수 있다.
				//input type ="file" name="f"가 가지고 있는 모든 파일들을 불러온다.
				//default 경로로 c: temp 폴더 안으로 들어간다.
		
		
		   //다중 파일 업로드
		   //view 코드 (JSP)
		   //<input type="file" name="files[0]"
		   //<input type="file" name="files[1]"
		
		   //DTO
		   //private List<CommonsMultipartFile> files   (setter , getter) 자동 주입
		      
		   //Controller
		   //noticeReg(Notice n)
		   return "redirect:notice.htm";
		}

	//글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
			
		    NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		    noticedao.delete(seq);
		    //noticedao.delete(seq);
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
		 
		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		Notice notice =  noticedao.getNotice(seq);
		//Notice notice =  noticedao.getNotice(seq);
		 model.addAttribute("notice", notice);
		 
		 //return "noticeEdit.jsp"; //forward 
		 return "customer.noticeEdit";
	  }
	
	@RequestMapping("download.htm")
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		/*
		 * //한글 처리 형식 지정 String sEncoding = new
		 * String(filename.getBytes("euc-kr"),"8859_1");
		 * response.setHeader("Content-Disposition","attachment;filename= " +
		 * sEncoding);
		 * //response.setHeader("Content-Disposition","attachment;filename= " + filename
		 * +";");
		 */
		// 한글 파일명 처리 (Filtter 처리 확인) -> 경우 ...
		// 한글 파일 깨짐 현상 해결하기
		// String fname = new String(f.getBytes("ISO8859_1"),"UTF-8");
		String fname = new String(f.getBytes("euc-kr"), "8859_1");
		System.out.println(fname);
		// 다운로드 기본 설정 (브라우져가 read 하지 않고 ... 다운 )
		// 요청 - 응답 간에 헤더정보에 설정을 강제 다운로드
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// new String(fname.getBytes(),"ISO8859_1"));
		response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");
		// 파일명 전송
		// 파일 내용전송
		String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
		System.out.println(fullpath);
		FileInputStream fin = new FileInputStream(fullpath);
		// 출력 도구 얻기 :response.getOutputStream()
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024]; // 전체를 다읽지 않고 1204byte씩 읽어서
		int size = 0;
		while ((size = fin.read(buf, 0, buf.length)) != -1) // buffer 에 1024byte
		// 담고
		{ // 마지막 남아있는 byte 담고 그다음 없으면 탈출
			sout.write(buf, 0, size); // 1kbyte씩 출력
		}
		fin.close();
		sout.close();
	}
}
