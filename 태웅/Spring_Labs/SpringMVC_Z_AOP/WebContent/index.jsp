<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    if (session.getAttribute("signedUser") == null) {
        response.sendRedirect("logout.jsp");
    }
%> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>

<body>
	<form action="login.do" method="post">
		<label>ID:&nbsp;</label> <input name="id" type="text"><br> 
		<label>PW:&nbsp;</label> <input name="pw" type="password"><br> 
		<input type="submit" value="로그인">
	</form>
</body>

</html>