package kr.or.bit.servlet.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.EmpDto;
import net.sf.json.JSONArray;

@WebServlet("/empListServlet")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpListServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmpDto> emplist = null;
		JSONArray jsonarray = null;
		try {
			EmpDao dao = new EmpDao();
			emplist = dao.getEmpAllList();
			jsonarray = JSONArray.fromObject(emplist);
			
		} catch (Exception e) {
			System.out.println("EmpListServlet 에러발생 : " + e.getMessage());
			e.printStackTrace();
		}finally {
			response.getWriter().print(jsonarray);
		}
	}
}
