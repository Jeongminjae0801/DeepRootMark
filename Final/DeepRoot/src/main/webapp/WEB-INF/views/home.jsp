<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Home</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$("#check-user-id").on("dblclick", function(){ });
		    $("#check-user-id").on("click", function(){
		    	$.ajax({ 
		    		url:"user/idcheck.do",
		            type:"POST",
		            data:{uid: $("#uid_join").val()},
		            dataType:"json",
		            success:function(data){  
		            	alert(data.result);
		            },
		            error:function(e){  
		                alert(e.responseText);  
		            }  
		        });
		    });
		    
		    $("#check-user-nickname").on("dblclick", function(){ });
		    $("#check-user-nickname").on("click", function(){
		    	$.ajax({ 
		    		url:"user/nnamecheck.do",
		            type:"POST",
		            data:{nname: $("#nname_join").val()},
		            dataType:"json",
		            success:function(data){  
		            	alert(data.result);
		            },
		            error:function(e){
		                alert(e.responseText);  
		            }  
		        });
		    });
		});
	</script>
</head>
<body>
	<h1>
		Main Home Page
	</h1>

	<h3>카테고리(admin)</h3>
	<ul>
		<c:forEach items="${categoryList}" var="category">
			<li>${category.acid}: ${category.acname}</li>
		</c:forEach>
	</ul>
	
	
	<h3>북마크(admin)</h3>
	<ul>
		<c:forEach items="${bookList}" var="books">
			<li>${books.acname}(${books.acid}): ${books.url}, ${books.urlname}, ${books.view}, ${books.regdate}</li>
		</c:forEach>
	</ul>
	
	<h3>회원가입</h3>
	<form method="post" action="user/register.do" accept-charset="UTF-8">
	    <input id="uid_join" type="text" placeholder="Email@example.com" name="uid">
	    <a id="check-user-id" style="border: 1px solid black;">아이디 중복확인</a>
	    <input id="nname_join" type="text" placeholder="Nickname" name="nname">
	    <a id="check-user-nickname" style="border: 1px solid black;">닉네임 중복확인</a>
	    <input type="password" placeholder="Password" name="pwd">
	    <input type="text" placeholder="Greetings" name="profile">
	    <input type="submit" value="Create account" name="commit">
	</form>

	
	
	
</body>
</html>
