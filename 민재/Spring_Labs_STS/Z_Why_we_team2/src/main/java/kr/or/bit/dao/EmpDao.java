package kr.or.bit.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.bit.dto.EmpDto;

public interface EmpDao {

	// 전체 조회
	List<EmpDto> getEmpAllList();
	
	// 하나 조회
	EmpDto getEmpAllList(Map<String, Integer> map);

	// 사원 추가
	int insertEmp(EmpDto emp);

	// 사원 정보 수정
	int updateEmp(EmpDto emp);

	// 사원 삭제
	int deleteEmp(int empno);
}
