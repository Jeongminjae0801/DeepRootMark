<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="content" class="container">
<form action="" method="POST">
    	<table class="article-list margin-small">
    	
			<tr><th>사번</th></tr>
			<tr><td><input type="text" id='empno' name="empno" placeholder='사번'></td></tr>
			<tr><td>이름</td></tr>
			<tr><td><input type="text" id='ename' name= "ename" placeholder='이름'></td></tr>
			<tr><td>직업</td></tr>
			<tr><td><input type="text" id='job' name="job" placeholder='직업'></td></tr>
			<tr><td>사수번호</td></tr>
			<tr><td><input type="text" id='mgr' name="mgr" placeholder='사수번호'></td></tr>
			<tr><td>급여</td></tr>
			<tr><td><input type="text" id='sal'name="sal" placeholder='급여'></td></tr>
			<tr><td>수당</td></tr>
			<tr><td><input type="text" id='comm' name="comm" placeholder='수당'></td></tr>
			<tr><td>부서번호</td></tr>
			<tr><td><input type="text" id='deptno' name="deptno" placeholder='부서번호'></td></tr>
		</table>
		<input type="submit" value="보내기" >
		</form>
		
		<a id='allinsertcancle'>취소</a>
    
</div>