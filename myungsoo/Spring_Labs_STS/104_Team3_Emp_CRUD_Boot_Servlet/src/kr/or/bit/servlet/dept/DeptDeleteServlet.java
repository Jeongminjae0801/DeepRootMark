package kr.or.bit.servlet.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.DeptDao;

@WebServlet("/deptDeleteServlet")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptDeleteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int deptno = Integer.parseInt(request.getParameter("deptno"));

		try {
			DeptDao dao = new DeptDao();

			dao.deleteDept(deptno);
			
		} catch (Exception e) {
			System.out.println("DeptDeleteServlet 에러발생 : " + e.getMessage());
		} 
	}
}
