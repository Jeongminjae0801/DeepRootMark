package kr.or.bit.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.bit.dto.EmpDto;
import kr.or.bit.utils.Singleton_Helper;

public class EmpDao {
	Connection conn = null;

	public EmpDao() {
		conn = Singleton_Helper.getConnection("oracle");
	}

	//사번 조회
	public EmpDto getEmpFindByEmpno(int empno) {

		String sql = "select * from emp where empno = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpDto dto = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				dto = new EmpDto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				dto.setHiredate((rs.getString("hiredate")).substring(0, 11));
				dto.setMgr(rs.getInt("mgr"));
				
			} else {
				dto = null;
			}
		} catch (Exception e) {
			System.out.println("empFindByEmpno 에러발생 : " + e.getMessage());
			
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		
		return dto;
	}

	//전체 조회
	public ArrayList<EmpDto> getEmpAllList() throws SQLException {

		PreparedStatement pstmt = null;
		String sql = "select empno,ename,job,nvl(mgr,0) as mgr,hiredate,sal,nvl(comm,0) as comm,deptno from emp order by empno";
		
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery(); 

		ArrayList<EmpDto> emplist = new ArrayList<EmpDto>();

		while (rs.next()) {

			EmpDto m = new EmpDto();
			
			m.setEmpno(rs.getInt("empno"));
			m.setEname(rs.getString("ename"));
			m.setJob(rs.getString("job"));
			m.setMgr(rs.getInt("mgr"));
			m.setHiredate((rs.getString("hiredate")).substring(0, 11));
			m.setSal(rs.getInt("sal"));
			m.setComm(rs.getInt("comm"));
			m.setDeptno(rs.getInt("deptno"));
			
			emplist.add(m);

		}

		Singleton_Helper.close(rs);
		Singleton_Helper.close(pstmt);

		return emplist;
	}
	
	//join 조회
	public ArrayList<EmpDto> getListDeptByDeptno(int deptno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpDto> emplist = null;
		try {
			String sql = "select e.empno, e.ename, e.job, nvl(e.mgr,0) as mgr,e.hiredate,e.sal,nvl(e.comm,0) as comm,e.deptno  from emp e join dept d on e.deptno = d.deptno where d.deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			
			emplist = new ArrayList<EmpDto>();
			
			while (rs.next()) {

				EmpDto m = new EmpDto();
				
				m.setEmpno(rs.getInt("empno"));
				m.setEname(rs.getString("ename"));
				m.setJob(rs.getString("job"));
				m.setMgr(rs.getInt("mgr"));
				m.setHiredate((rs.getString("hiredate")).substring(0, 11));
				m.setSal(rs.getInt("sal"));
				m.setComm(rs.getInt("comm"));
				m.setDeptno(rs.getInt("deptno"));
				
				emplist.add(m);

			}

		} catch (Exception e) {
			System.out.println("getDeptListByDeptno 에러발생 : " + e.getMessage());
			
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return emplist;
	}

	//사원 추가
	public int insertEmp(EmpDto emp) {

		int resultrow = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into emp(empno, ename, job, mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			resultrow = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("empInsert 에러발생 :" + e.getMessage());
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return resultrow;
	}

	//사원 정보 수정
	public int updateEmp(EmpDto emp) {

		int resultrow=0;
		PreparedStatement pstmt = null;

		try {
			String sql="update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setString(4, emp.getHiredate());
			pstmt.setInt(5, emp.getSal());
			pstmt.setInt(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptno());
			pstmt.setInt(8, emp.getEmpno());
			
			resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("empUpdate 에러 발생: " + e.getMessage());
		}finally {
			Singleton_Helper.close(pstmt);
		}
		
		return resultrow;
	}

	//사원 삭제
	public int deleteEmp(int empno) {

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "delete from emp where empno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("empDelete 에러 발생 : " + e.getMessage());
		} finally {

		}

		return result;
	}

	// 추가함수 (비동기 통해서 ID 유무 등등)

}
