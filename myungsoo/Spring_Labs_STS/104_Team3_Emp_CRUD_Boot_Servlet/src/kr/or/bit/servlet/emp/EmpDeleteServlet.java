package kr.or.bit.servlet.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.EmpDao;

@WebServlet("/empDeleteServlet")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpDeleteServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int empNo = Integer.parseInt(request.getParameter("empno"));

		try {
			EmpDao dao = new EmpDao();

			dao.deleteEmp(empNo);
			
		} catch (Exception e) {
			System.out.println("EmpDeleteServlet 에러발생 : " + e.getMessage());
		} 
	}
}
