<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<h2>관리자 페이지</h2>

	<c:forEach items="${gCount}" var="g">
		<ul>
			<li>${g.d}</li>
			<li>${g.c}</li>
		</ul>
	</c:forEach>


 	<c:forEach items="${categoryList}" var="category">
		<ul>
			<li>${category.acid}</li>
			<li>${category.acname}</li>
		</ul>
	</c:forEach>

	<h3>카테고리 추가</h3>
	<form action="addCategory.do" method="post">
		카테고리 이름 <input type="text" id="acname" name="acname">
		<button type="submit">추가</button>
	</form>
	
	<h3>카테고리 수정</h3>
	<form action="updateCategory.do" method="post">
		카테고리 번호 <input type="text" id="acname" name="acid">
		카테고리 이름 <input type="text" id="acname" name="acname">
		<button type="submit">수정</button>
	</form>
	
	<h3>카테고리 삭제</h3>
	<form action="deleteCategory.do" method="post">
		카테고리 번호 <input type="text" id="acname" name="acid">
		<button type="submit">삭제</button>
	</form>
	
	<c:forEach items="${bookList}" var="book">
		<ul>
			<li>${book.abid}</li>
			<li>${book.url}</li>
			<li>${book.urlname}</li>
			<li>${book.regdate}</li>
			<li>${book.view}</li>
			<li>${book.acid}</li>
		</ul>
	</c:forEach>
	
	<h3>관리자 URL 추가</h3>
	<form action="addBook.do" method="post">
		URL <input type="text" id="url" name="url">
		URLNAME <input type="text" id="urlname" name="urlname">
		관리자 카테고리 번호 <input type="text" id="acid" name="acid">
		<button type="submit">추가</button>
	</form>
	
	<h3>관리자 URL 수정</h3>
	<form action="updateBook.do" method="post">
		ABID <input type="text" id="abid" name="abid">
		URL <input type="text" id="url" name="url">
		URLNAME <input type="text" id="urlname" name="urlname">
		<button type="submit">수정</button>
	</form>
	
	<h3>관리자 URL 삭제</h3>
	<form action="deleteBook.do" method="post">
		ABID <input type="text" id="abid" name="abid">
		<button type="submit">삭제</button>
	</form>
	
</body>
</html>