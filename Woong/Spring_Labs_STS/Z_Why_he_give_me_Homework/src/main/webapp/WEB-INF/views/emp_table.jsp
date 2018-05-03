<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>3Group 사원 관리</title>

</head>

<body id="page-top">
	<section class="portfolio">
		<div class="container">
			<div id="menu" style="text-align:left">
				<button id="empallsearch">전체보기</button><button id="empinsert">사원추가</button>
			</div>
			<div id="tablespace" class="table-responsive">
				<table>
					<thead>
						<tr>
							<th width="7%">사번</th>
							<th width="15%">이름</th>
							<th width="15%">직업</th>
							<th width="7%">사수번호</th>
							<th width="15%">입사일</th>
							<th width="10%">급여</th>
							<th width="10%">수당</th>
							<th width="10%">부서번호</th>
							<th width="11%" colspan="2">작업공간</th>
						</tr>
					</thead>
					<tbody class="mybox emp">
						<c:forEach items="${list}" var="emp" >
							<script type="text/javascript">
								console.log("zzzzzz");
							</script>
							<tr>
								<td>${emp.empno}</td>
								<td>${emp.ename}</td>
								<td>${emp.job}</td>
								<td>${emp.mgr}</td>
								<td>${emp.hiredate}</td>
								<td>${emp.sal}</td>
								<td>${emp.comm}</td>
								<td>${emp.deptno}</td>
								<td><a href='#'>수정</a></td>
								<td><a href='#'>삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br>
		</div>
	</section>
	
</body>

</html>