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

@WebServlet("/allListFindByDeptnoServlet")
public class AllListFindByDeptnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllListFindByDeptnoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		EmpDao dao = null;
		DeptDao deptdao = null;
		JSONObject json = null;
		try {
			dao = new EmpDao();
			deptdao = new DeptDao();
			List<EmpDto> emplist = dao.getListDeptByDeptno(deptno);
			
			Map<String, List<Object>> map =null;
			
			if(emplist.size() != 0) {
				int i = 1;
				map = new HashMap<>();
				for(EmpDto e : emplist) {
					DeptDto dept = deptdao.getDeptByDeptno(e.getDeptno());
					List<Object> list = new ArrayList<>();
					list.add(e);
					list.add(dept);
					map.put(String.valueOf(i), list);
					i++;
				}
			}
			json = JSONObject.fromObject(map);
			
		} catch (Exception e) {
			System.out.println("AllFindByEmpnoAction 에러발생 : " + e.getMessage());
		}finally {
			response.getWriter().print(json);
		}
		
	}

}
