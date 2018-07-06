<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
	<h2>회원 확인</h2>
	<h3 class="hidden">방문페이지 로그</h3>
	<ul id="breadscrumb" class="block_hlist clear">
		<li>HOME</li>
		<li>회원가입</li>
		<li>로그인</li>
	</ul>
	<h3 class="hidden">회원가입 폼</h3>
	
	<div id="join-form" class="join-form margin-large">
		<c:if test="${param.error != null}">
	   		<div>
	     		   로그인실패<br>
	     		  <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
	     	 	    이유 : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
	     	   </c:if>
	   		</div>
  		</c:if>  

		<form method="post">
			<fieldset>
				<legend class="hidden">회원확인 폼</legend>
				<h3>
					<img src="images/txtTitle.png" />
				</h3>
				<ul id="loginBox">
					<li><label for="pwd">비밀번호</label>
					    <input type="password" name="password" class="text" /></li>
				</ul>
				<p>
					<input type="submit" id="btnLogin" value="" />
				</p>
				<ul id="loginOption">
				</ul>
			</fieldset>
		</form>
	</div>

</div>
