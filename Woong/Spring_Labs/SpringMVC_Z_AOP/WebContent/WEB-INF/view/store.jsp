<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
		<h3>[ KIA K Series Index ]</h3>
		<input type="radio" name="car" checked="checked">K3<br>
	  	<input type="radio" name="car">K5<br>
		<input type="radio" name="car">K7<br>
		<input type="radio" name="car">K9<br>
		
		<input type="submit" value="구매하기">
		<input type="button" value="취소하기" onclick="location.href='main.do'">
	</form>
</body>
</html>