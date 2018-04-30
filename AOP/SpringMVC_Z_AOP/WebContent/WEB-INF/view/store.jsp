<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="buycar.do">
		<h3>[ KIA K Series Index ]</h3>
		<!-- 각 링크를 눌렀을 때, 차량에 맞는 view 페이지를 보여주는게 맞다고 봄. -->
		<!-- 공통 관심사로는 상단 KIA -->
		<input type="radio" name="carName" value="K3" checked><a href="#">K3</a><br>
	  	<input type="radio" name="carName" value="K5"><a href="#">K5</a><br>
		<input type="radio" name="carName" value="K7"><a href="#">K7</a><br>
		<input type="radio" name="carName" value="K9"><a href="#">K9</a><br>
		
		<!-- 공통 관심사: 상단에 사용자 이름 + 현재시간, 하단에 구매가격  -->
		<input type="submit" value="구매하기">
		<input type="button" value="취소하기" onclick="location.href='main.do'">
	</form>
</body>
</html>