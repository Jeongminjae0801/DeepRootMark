package kr.or.bit.servlet.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.EmpDto;
import net.sf.json.JSONObject;

@WebServlet("/empFindByEmpnoServlet")
public class EmpFindByEmpnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpFindByEmpnoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		JSONObject json = null;
		try {
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmpDao dao = new EmpDao();
			EmpDto emp = dao.getEmpFindByEmpno(empno);
			json = JSONObject.fromObject(emp);

		} catch (Exception e) {
			System.out.println("EmpFindByEmpnoServlet 에러발생 : " + e.getMessage());
		}finally {
			response.getWriter().print(json);
		}

	}

}
