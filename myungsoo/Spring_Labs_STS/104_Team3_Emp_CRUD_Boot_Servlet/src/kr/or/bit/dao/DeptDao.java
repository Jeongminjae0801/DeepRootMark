package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.DeptDto;
import kr.or.bit.utils.Singleton_Helper;

public class DeptDao {
	Connection conn = null;
			
	public DeptDao() {
		conn = Singleton_Helper.getConnection("oracle");
	}

	// 1. 전체 조회
	public List<DeptDto> getDeptAllList() {
		List<DeptDto> deptList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select deptno, dname, loc from dept order by deptno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			deptList = new ArrayList<>();
			if(rs.next()) {
				do {
					DeptDto dept = new DeptDto();
					dept.setDeptno(rs.getInt(1));
					dept.setDname(rs.getString(2));
					dept.setLoc(rs.getString(3));
					
					deptList.add(dept);
				}while(rs.next());
			}
		} catch (Exception e) {
			System.out.println("getDeptAllList 에러발생 : " + e.getMessage());
			
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return deptList;
	}

	// 2. 조건 조회
	public DeptDto getDeptByDeptno(int deptno) {
		DeptDto dept = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select deptno, dname, loc from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dept = new DeptDto();
				dept.setDeptno(rs.getInt(1));
				dept.setDname(rs.getString(2));
				dept.setLoc(rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println("getDeptListByDeptno 에러발생 : " + e.getMessage());
			
		} finally {
			Singleton_Helper.close(rs);
			Singleton_Helper.close(pstmt);
		}
		return dept;
	}

	// 3. 데이터 삽입
	public int insertDept(DeptDto dept) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("insertDept 에러발생 : " + e.getMessage());
			
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return result;
	}

	// 4. 데이터 수정
	public int updateDept(DeptDto dept) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "update dept set dname = ? , loc = ? where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateDept 에러발생 : " + e.getMessage());
			
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return result;
	}

	// 5. 데이터 삭제
	public int deleteDept(int deptno) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "delete from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("updateDept 에러발생 : " + e.getMessage());
			
		} finally {
			Singleton_Helper.close(pstmt);
		}
		return result;
	}


	
	
}
