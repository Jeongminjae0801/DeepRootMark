package kr.or.bit.servlet.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.EmpDto;

@WebServlet("/empUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpUpdateServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		EmpDto dto = new EmpDto();
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		String hiredate = request.getParameter("hiredate");
		/*Date hiredate = Date.valueOf(getHiredate);*/
		int sal = Integer.parseInt(request.getParameter("sal"));
		int comm = Integer.parseInt(request.getParameter("comm"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		dto.setEmpno(empno);
		dto.setEname(ename);
		dto.setJob(job);
		dto.setMgr(mgr);
		dto.setHiredate(hiredate);
		dto.setSal(sal);
		dto.setComm(comm);
		dto.setDeptno(deptno);

		try {
			EmpDao dao = new EmpDao();
			
			dao.updateEmp(dto);
			
		}catch(Exception e) {
			System.out.println("EmpUpdateServlet 에러 발생 : " + e.getMessage());
		}
	}
}
