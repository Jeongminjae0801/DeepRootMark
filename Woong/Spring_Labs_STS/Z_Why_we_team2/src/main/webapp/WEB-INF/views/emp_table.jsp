<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	

<section class="portfolio">
	<div class="container">
		<div id="menu" style="text-align:left">
		
			성 명&nbsp;<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
			
			<!-- <button id="empallsearch">전체보기</button> -->
			<button id="empinsert" onclick='location.href="insert.htm"'>사원추가</button>
			
		</div>
		
		<div id="tablespace" >
			<table id=myTable>
				<thead>
					<tr>
						<th width="7%" onclick="sortTable(0)">사번</th>
						<th width="15%" onclick="sortTable(1)">이름</th>
						<th width="15%" onclick="sortTable(2)">직업</th>
						<th width="7%" onclick="sortTable(3)">사수번호</th>
						<th width="15%" onclick="sortTable(4)">입사일</th>
						<th width="10%" onclick="sortTable(5)">급여</th>
						<th width="10%" onclick="sortTable(6)">수당</th>
						<th width="10%" onclick="sortTable(7)">부서번호</th>
						<th width="11%" colspan="2">작업공간</th>
					</tr>
				</thead>
				<tbody class="mybox emp">
					<c:forEach items="${list}" var="emp" >
						<tr>
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.job}</td>
							<td>${emp.mgr}</td>
							<td>${emp.hiredate}</td>
							<td>${emp.sal}</td>
							<td>${emp.comm}</td>
							<td>${emp.deptno}</td>
							<td><a href='update.htm?empno=${emp.empno}'>수정</a></td>
							<td><a href='del.htm?empno=${emp.empno}'>삭제</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br>
	</div>
</section>
	

