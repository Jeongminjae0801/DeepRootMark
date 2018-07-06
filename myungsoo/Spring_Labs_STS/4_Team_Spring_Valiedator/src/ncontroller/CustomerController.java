package ncontroller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

// >/customer/notice.htm
// >/customer/noticeDetail.htm


@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
	private SqlSession sqlSession;
	//org.mybatis.spring.SqlSessionTemplate 객체의 주소값
	
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
			NoticeDao noticedao = sqlSession.getMapper(NoticeDao.class);
			
			list = noticedao.getNotices(page, field, query);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		//ModelAndView 객체 사용가능
		//return new ModelAndView
		
		//Model : 데이터 담기
		//return :view 주소 
		model.addAttribute("list", list); //View 단 페이지에 자동 forward (list 이름으로)
		
		//return "notice.jsp";
		return "customer.notice";
	}
	
	//글 상세보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) {
		
		Notice notice=null;
		try {
			NoticeDao noticedao = sqlSession.getMapper(NoticeDao.class);
			
			notice = noticedao.getNotice(seq);
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
	//글쓰기 (처리)
	//@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	//public int insert(Notice n) ...
	//customer/upload 업로드 경로
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice n, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
			
		   //다중 파일 업로드
		   //view 코드 (JSP)
		   //<input type="file" name="files[0]"
		   //<input type="file" name="files[1]"
		
		   //DTO
		   //private List<CommonsMultipartFile> files   (setter , getter) 자동 주입
		      
		   //Controller
		   //noticeReg(Notice n)
		   System.out.println("다중 파일 업로드");
		   System.out.println("n :" + n.getTitle());
		   System.out.println("n :" + n.getContent());
		   System.out.println("n 업로드 개수 :" + n.getFiles().size());
		   System.out.println("n :" + n.getFiles().get(0).getName());
		   System.out.println("n :" + n.getFiles().get(1).getName());
		   
		   List<CommonsMultipartFile> files = n.getFiles();
		   List<String> filenames = new ArrayList<>(); //파일명 담아넣기 (DB Insert)
		   
		   if(files != null && files.size() > 0) {
			   for(CommonsMultipartFile multifile : files) {
				    
				    String filename = multifile.getOriginalFilename();
				    String path = request.getServletContext().getRealPath("/customer/upload");
					String fpath = path + "\\" + filename;
			
					if(!filename.equals("")) { //파일 쓰기
						FileOutputStream fs = new FileOutputStream(fpath);
						fs.write(multifile.getBytes());
						fs.close();
					}
					filenames.add(filename); //DB insert 파일명	
			   }
		   }
		   //실 DB INSERT
		   n.setFileSrc(filenames.get(0));
		   n.setFileSrc2(filenames.get(1));
		 
		   NoticeDao noticedao = sqlSession.getMapper(NoticeDao.class);
			
		   noticedao.insert(n);
		   return "redirect:notice.htm";
		   
		  /*
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
			return "notice.htm";//redirect:
		    */
		   
	
			
		}

	//글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
			
		NoticeDao noticedao = sqlSession.getMapper(NoticeDao.class);
	
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
		NoticeDao noticedao = sqlSession.getMapper(NoticeDao.class);
		
		Notice notice =  noticedao.getNotice(seq);
		model.addAttribute("notice", notice);
		 
		//return "noticeEdit.jsp"; //forward 
		return "customer.noticeEdit";
	}
	
	//글수정하기(수정 처리)
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.POST )
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		List<CommonsMultipartFile> files = n.getFiles();
		   List<String> filenames = new ArrayList<>(); //파일명 담아넣기 (DB Insert)
		   
		   if(files != null && files.size() > 0) {
			   for(CommonsMultipartFile multifile : files) {
				    
				    String filename = multifile.getOriginalFilename();
				    String path = request.getServletContext().getRealPath("/customer/upload");
					String fpath = path + "\\" + filename;
			
					if(!filename.equals("")) { //파일 쓰기
						FileOutputStream fs = new FileOutputStream(fpath);
						fs.write(multifile.getBytes());
						fs.close();
					}
					filenames.add(filename); //DB insert 파일명	
			   }
		   }
		   //실 DB INSERT
		   n.setFileSrc(filenames.get(0));
		   n.setFileSrc2(filenames.get(1));
		  
		   NoticeDao noticedao = sqlSession.getMapper(NoticeDao.class);
			
		   noticedao.update(n);
		   return "redirect:noticeDetail.htm?seq="+n.getSeq();

		  //update
		  //fileupload
		  /*
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
		  */
		
	  }

}
