package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Service
public class CustomerService {
	@Autowired
	private SqlSession session;

	// 글 전체 보기
	public List<Notice> notices(String pg, String f, String q) {
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

		// DAO 객체 생성 ... 함수 호출
		List<Notice> list = null;
		try {
			// list = noticedao.getNotices(page, field, query);
			NoticeDao dao = session.getMapper(NoticeDao.class);
			list = dao.getNotices(page, field, query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 글 상세보기 서비스
	public Notice noticeDetail(String seq) {

		Notice notice = null;
		try {
			// notice = noticedao.getNotice(seq);
			NoticeDao dao = session.getMapper(NoticeDao.class);
			notice = dao.getNotice(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return notice;
	}

	// 글쓰기 (처리)
	@Transactional
	public void noticeReg(Notice n, HttpServletRequest request) throws Exception {

		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명 담아넣기 (DB Insert)

		if (files != null && files.size() > 0) {
			for (CommonsMultipartFile multifile : files) {

				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;

				if (!filename.equals("")) { // 파일 쓰기
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); // DB insert 파일명
			}
		}
		// 실 DB INSERT
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));

		try {
			NoticeDao dao = session.getMapper(NoticeDao.class);
			dao.insert(n);
			dao.insertOfMemberPoint("woong");
		} catch (Exception e) {
			System.out.println("Transaction 예외 발생" + e.getMessage());
			throw e; // 예외 발생 시기면 : 자동 rollback
		}

	}

	// 글삭제하기
	public void noticeDel(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao dao = session.getMapper(NoticeDao.class);
		dao.delete(seq);
	}

	// 글 수정하기 (수정하기 화면)
	public Notice noticeEdit(String seq) throws ClassNotFoundException, SQLException {
		NoticeDao dao = session.getMapper(NoticeDao.class);
		Notice notice = dao.getNotice(seq);

		return notice;
	}

	// 글수정하기(수정 처리)
	public void noticeEdit(Notice n, HttpServletRequest request)
			throws IOException, ClassNotFoundException, SQLException {
		List<CommonsMultipartFile> files = n.getFiles();
		List<String> filenames = new ArrayList<String>(); // 파일명 담아넣기 (DB Insert)

		if (files != null && files.size() > 0) {
			for (CommonsMultipartFile multifile : files) {

				String filename = multifile.getOriginalFilename();
				String path = request.getServletContext().getRealPath("/customer/upload");
				String fpath = path + "\\" + filename;

				if (!filename.equals("")) { // 파일 쓰기
					FileOutputStream fs = new FileOutputStream(fpath);
					fs.write(multifile.getBytes());
					fs.close();
				}
				filenames.add(filename); // DB insert 파일명
			}
		}
		// 실 DB INSERT
		n.setFileSrc(filenames.get(0));
		n.setFileSrc2(filenames.get(1));

		NoticeDao dao = session.getMapper(NoticeDao.class);
		dao.update(n);
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
