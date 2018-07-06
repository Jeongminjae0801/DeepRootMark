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

@WebServlet("/allListServlet")
public class AllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllListServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao empdao = new EmpDao();
		DeptDao deptdao = new DeptDao();
		JSONObject json = null;
		try {
			
			List<EmpDto> emplist = empdao.getEmpAllList();
			
			Map<String, List<Object>> map = new HashMap<>();
			
			int i = 1;
			for(EmpDto e : emplist) {
				DeptDto dept = deptdao.getDeptByDeptno(e.getDeptno());
				List<Object> list = new ArrayList<>();
				list.add(e);
				list.add(dept);
				map.put(String.valueOf(i), list);
				i++;
			}
			
			json = JSONObject.fromObject(map);
		
		} catch (Exception e) {
			System.out.println("AllListServlet 에러발생 : " + e.getMessage());

		}finally {
			response.getWriter().print(json);
		}
		
	}
}
