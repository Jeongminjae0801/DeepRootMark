package dao;

import java.util.ArrayList;
import java.util.HashMap;

import dto.EmpDto;

public interface EmpDaoI {


	ArrayList<EmpDto> getEmpAllList();
	int insertEmp(HashMap<String, String> param);
	int deletEmp(HashMap<String, String> param);
	
/*	ArrayList<EmpDto> getListDeptByDeptno(int deptno);
 * 	EmpDto getEmpFindByEmpno(int empno);
 * int insertEmp(EmpDto emp);
	int updateEmp(EmpDto emp);
	int deleteEmp(int empno);*/
}
