package kr.or.bit.dao;

import java.util.ArrayList;

import kr.or.bit.dto.EmpDto;

public interface EmpDao {

	// 전체 조회
	ArrayList<EmpDto> getEmpAllList();

	// 사원 추가
	int insertEmp(EmpDto emp);

	// 사원 정보 수정
	int updateEmp(EmpDto emp);

	// 사원 삭제
	int deleteEmp(int empno);
}
