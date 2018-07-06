package kr.or.bit.servlet.all;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.DeptDao;
import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.DeptDto;
import kr.or.bit.dto.EmpDto;
import net.sf.json.JSONObject;

@WebServlet("/allFindByDeptnoServlet")
public class FindByDeptnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindByDeptnoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		EmpDao dao = null;
		EmpDto emp = null;
		JSONObject json = null;
		try {
			dao = new EmpDao();
			emp = dao.getEmpFindByEmpno(empno);
			Map<String, List<Object>> map = null;
			
			if(emp != null) {
				DeptDao deptdao = new DeptDao();
				
				DeptDto dept = deptdao.getDeptByDeptno(emp.getDeptno());
				
				List<Object> list = new ArrayList<>();
				list.add(emp);
				list.add(dept);
				
				map = new HashMap<>();
				
				map.put("1",list);
				
			}
			json = JSONObject.fromObject(map);
			
		} catch (Exception e) {
			System.out.println("AllFindByEmpnoAction 에러발생 : " + e.getMessage());
		}finally {
			response.getWriter().print(json);
		}
		
	}

}
