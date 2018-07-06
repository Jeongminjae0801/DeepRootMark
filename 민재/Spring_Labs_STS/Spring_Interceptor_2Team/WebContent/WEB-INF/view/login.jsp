<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인 페이지입니다</h3>
<hr>
<a href="write.do">글 쓰기</a>
<a href="update.do">글 수정</a>
<a href="delete.do">글 삭제</a>
<br><br>
<form action="loginOk.do" method="post">
	<label>ID:&nbsp;</label> <input name="id" type="text"><br> 
	<label>PW:&nbsp;</label> <input name="pw" type="password"><br> 
	<input type="submit" value="로그인">
</form>
</body>
</html>