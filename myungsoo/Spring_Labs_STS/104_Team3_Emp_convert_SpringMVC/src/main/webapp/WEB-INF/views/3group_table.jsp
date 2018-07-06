<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   	<section class="portfolio" >
      <div class="container">
		<div style="text-align: left" id="menu">
		</div>
		<div id="tablespace" class="table-responsive">
		
		<a href="addemp.htm"><button type="button">사원 추가하기</button></a>
		<table id="tab" class="article-list margin-small">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>직업</th>
				<th>mgr</th>
				<th>채용일</th>
				<th>월급</th>
				<th>comm</th>
				<th>부서번호</th>
				<th>작업공간</th>

				
			</tr>
		</thead>
		<tbody>
		<%-- <%= request.getAttribute("list") %> --%>
			<c:forEach items="${list}" var="emp">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.mgr}</td>
					<td>${emp.hiredate}</td>
					<td>${emp.sal}</td>
					<td>${emp.comm}</td>
					<td>${emp.deptno}</td>
					<td><a href="del.htm?empno=${emp.empno}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

		</div>
      	<br>
      </div>
    </section>
    
    
<!-- 


s -->