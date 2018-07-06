package kr.or.bit.servlet.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.DeptDao;
import kr.or.bit.dto.DeptDto;

@WebServlet("/deptInsertServlet")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptInsertServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		DeptDto dto = new DeptDto();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		try {
			DeptDao dao = new DeptDao();
			
			dao.insertDept(dto);
		} catch (Exception e) {
			System.out.println("DeptInsertServlet 에러발생 : " + e.getMessage());
		} 
	}

}
