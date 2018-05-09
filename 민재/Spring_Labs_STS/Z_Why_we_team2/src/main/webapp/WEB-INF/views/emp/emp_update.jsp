<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main" >
<c:set var="emp" value="${emp}" ></c:set>
<%
	
%>
	<form action="update.htm" method="post">
	<center>
		사 번 <input class="form-control" type="text" name="empno" style="margin:5px; width: 35%" readonly="readonly" value="${emp.empno}"> 
		성 명 <input class="form-control" type="text" name="ename" style="margin:5px; width: 35%" placeholder="이름" value="${emp.ename}">
		직 업 <input class="form-control" type="text" name="job" style="margin:5px; width: 35%" placeholder="직업" value="${emp.job}">
		사수번호 <input class="form-control" type="text" name="mgr" style="margin:5px; width: 35%" placeholder="사수번호" value="${emp.mgr}">
	 	<input class="form-control" type="hidden" name="hiredate" style="margin:5px; width: 35%" readonly="readonly" value="${emp.hiredate}">
		급 여<input class="form-control" type="text" name="sal" style="margin:5px; width: 35%" placeholder="급여" value="${emp.sal}">
		수 당<input class="form-control" type="text" name="comm" style="margin:5px; width: 35%" placeholder="수당" value="${emp.comm}">
		부서번호 <input class="form-control" type="text" name="deptno" style="margin:5px; width: 35%" placeholder="부서번호" value="${emp.deptno}"> 
		
		<div style="width: 35%">
			<input class="form-control btn btn-success" type="submit" value="수정" style="margin-bottom:5px; width: 100%">
			<input class="form-control btn btn-danger" type="reset" value="초기화" style="margin-bottom:5px; width: 100%">
		</div>
	</center>
	</form>

</div>
</body>
</html>