<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main" >
			
	
	<form method="post">
	<center>
		사 번<input class="form-control" type="text" name="empno" style="margin:5px; width: 35%" placeholder="사번">
		성 명<input class="form-control" type="text" name="ename" style="margin:5px; width: 35%" placeholder="이름">
		직 업<input class="form-control" type="text" name="job" style="margin:5px; width: 35%" placeholder="직업">
		사수번호<input class="form-control" type="text" name="mgr" style="margin:5px; width: 35%" placeholder="사수번호">
		<input class="form-control" type="hidden" name="hiredate" style="margin:5px; width: 35%" placeholder="입사일 (YYYY-MM-DD)">
		급 여<input class="form-control" type="text" name="sal" style="margin:5px; width: 35%" placeholder="급여">
		수 당<input class="form-control" type="text" name="comm" style="margin:5px; width: 35%" placeholder="수당">
		부서번호<input class="form-control" type="text" name="deptno" style="margin:5px; width: 35%" placeholder="부서번호"> 
		
		<div style="width: 35%">
		<input class="form-control btn btn-success" type="submit" value="추가" style="margin-bottom:5px; width: 100%">
		<input class="form-control btn btn-danger" type="reset" value="초기화" style="margin-bottom:5px; width: 100%">
		</div>
	</center>
	</form>

</div>
</body>
</html>