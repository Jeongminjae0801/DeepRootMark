package kr.or.bit.servlet.dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.DeptDao;
import kr.or.bit.dto.DeptDto;
import net.sf.json.JSONObject;

@WebServlet("/deptFindByDeptnoServlet")
public class DeptFindByEmpnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptFindByEmpnoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		JSONObject json = null;
		try {
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			DeptDao dao = new DeptDao();
			DeptDto dept = dao.getDeptByDeptno(deptno);
		
			json = JSONObject.fromObject(dept);

		} catch (Exception e) {
			System.out.println("DeptFindByEmpnoServlet 에러발생 : " + e.getMessage());
		}finally {
			response.getWriter().print(json);
		}

	}

}
