package kr.or.bit.servlet.dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.DeptDao;
import kr.or.bit.dto.DeptDto;
import net.sf.json.JSONArray;

@WebServlet("/deptListServlet")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptListServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DeptDto> deptlist = null;
		JSONArray jsonarray = null;
		try {
			DeptDao dao = new DeptDao();
			deptlist = dao.getDeptAllList();
			jsonarray = JSONArray.fromObject(deptlist);
			
		} catch (Exception e) {
			System.out.println("DeptListServlet 에러발생 : " + e.getMessage());
		}finally {
			response.getWriter().print(jsonarray);
		}
	}
}
