package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

/*
Controller -> Service -> DB 작업 (Mybatis)
*/

@Service
public class CustomerService {

	@Autowired
	private SqlSession sqlsession;

	// 글목록보기 서비스
	public List<Notice> notices(String pg, String f, String q) throws ClassNotFoundException, SQLException {

		int page = 1;
		String field = "TITLE";
		String query = "%%";

		// 조건 조합
		if (pg != null && !pg.equals("")) {
			page = Integer.parseInt(pg);
		}

		if (f != null && !f.equals("")) {
			field = f;
		}

		if (q != null && !q.equals("")) {
			query = q;
		}

		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		List<Notice> list = noticedao.getNotices(page, field, query);

		return list;
	}

	// 글 상세보기 서비스
	public Notice noticeDetail(String seq) throws ClassNotFoundException, SQLException {

		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticedao.getNotice(seq);

		return notice;
	}

	// 글쓰기 서비스
	@Transactional
	public String noticeReg(Notice n, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {

		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<>(); // 파일명만 추출
		if (files != null && files.size() > 0) {
			for (CommonsMultipartFile mutifile : files) {
				String filename = mutifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;
				System.out.println(filename + " , " + fpath);
				if (!filename.equals("")) {
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(mutifile.getBytes());
					fs.close();
				}
				filenames.add(filename);
			}
		}

		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));

		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		// 기존 코드
		// noticedao.insert(n);

		// 트랜잭션 적용코드 (게시판 글쓰기 하면 회원에게 POINT 1점 추가 : constraint ck_member_hit check(point
		// < 3)
		try {
			noticedao.insert(n); // 게시판 글쓰기
            noticedao.insertOfMemberPoint("admin");
			System.out.println("board insert , member point update");
		} catch (Exception e) {
			System.out.println("Transaction 예외 발생" + e.getMessage());
			throw e; // 예외 발생 시기면 : 자동 rollback
		}

		return "redirect:notice.htm";
	}

	// 글 삭제하기
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {

		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.delete(seq);
		return "redirect:notice.htm";
	}

	// 글수정하기 (화면)
	public Notice noticeEdit(String seq) throws ClassNotFoundException, SQLException {

		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		Notice notice = noticedao.getNotice(seq);

		return notice;
	}

	// 글수정하기(처리)
	public String noticeEdit(Notice n, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {

		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>();// 파일명만 추출

		if (files != null && files.size() > 0) {
			// 업로드한 파일이 하나라도 있다면
			for (CommonsMultipartFile multifile : files) {
				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;
				System.out.println(filename + "/" + fpath);
				if (!filename.equals("")) {
					// 서버에 파일 쓰기 작업
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename);// 실제 DB insert 할 파일명
			}
		}
		// DB작업
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));

		NoticeDao noticedao = sqlsession.getMapper(NoticeDao.class);
		noticedao.update(n);
		return "redirect:noticeDetail.htm?seq=" + n.getSeq();
	}

	// 파일 다운로드
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String fname = new String(f.getBytes("euc-kr"), "8859_1");
		response.setHeader("Content-Disposition", "attachment;filename=" + fname + ";");

		String fullpath = request.getServletContext().getRealPath("/customer/" + p + "/" + f);
		System.out.println(fullpath);
		FileInputStream fin = new FileInputStream(fullpath);

		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024]; // 전체를 다읽지 않고 1204byte씩 읽어서
		int size = 0;
		while ((size = fin.read(buf, 0, buf.length)) != -1) {
			sout.write(buf, 0, size);
		}
		fin.close();
		sout.close();
	}
}