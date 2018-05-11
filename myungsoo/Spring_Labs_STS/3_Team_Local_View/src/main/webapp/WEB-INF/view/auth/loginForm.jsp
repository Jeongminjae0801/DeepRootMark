<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head><title>Simple Business Card</title>
<script type="text/javascript">
function mysubmit(sub){
//간단한 유효성 검증	
if(document.myform.company.value==""){
	alert("회사명을 입력해주세요");
	return;
}
if(document.myform.name.value==""){
	alert("이름을 입력해주세요");
	return;
}
//엑셀뷰로 전달
if(sub==1){
 document.myform.action="../pagestat/rank";
 }
//pdf뷰로 전달
if(sub==2){
 document.myform.action="../pagestat/rankreport";
}
document.myform.submit();
}
</script>
</head>
<body>

	<div class = "container" style="text-align: center;">
		<form name="myform" method="post">
		<div class="panel panel-success" style="margin-top:50px;width:500px" >
	      <div class="panel-heading"><spring:message code="form.title"/></div>
	     
	      
	      
	      <div class="panel-body">
	      
			<a href="../changeLanguage?lang=ja">日本語</a> &nbsp;&nbsp;&nbsp;
			<a href="../changeLanguage?lang=en">English</a>&nbsp;&nbsp;&nbsp;
			<a href="../changeLanguage?lang=kor">한글</a>

		
			<table class="table" style="margin-top: 10px">
			  	  <colgroup>
			  	  	<col width="30%" />
					<col width="70%" />
			  	  </colgroup>
			  	
	
			      <tr>			     
			        <td class="active"><label for="company"><spring:message code="company" /></label> </td>
			        <td><input type="text" name="company" id="company" size="30" /> </td>
			      </tr>
			      <tr>			     
			        <td class="active"><label for="name"><spring:message code="name" /></label> </td>
			        <td><input type="text" name="name" id="name"  size="30"></td>
			      </tr>
			      <tr>			     
			        <td class="active"><label for="phone"><spring:message code="phone" /></label> </td>
			        <td><input type="text" name="phone" id="phone"  size="30"></td>
			      </tr>
			      <tr>			     
			        <td class="active"><label for="email"><spring:message code="email" /></label> </td>
			        <td><input type="text" name="email" id="email" size="30"></td>
			      </tr>
<%-- 		   <td><input type="text" name="email" id="email" value="${loginCommand.email}"></td> --%>
					    
		  </table>
		
			<input type="button" class="btn btn-info" value="<spring:message code="form.excel" />" onclick="mysubmit(1)">
			<input type="button" class="btn btn-danger" value="<spring:message code="form.pdf" />" onclick="mysubmit(2)">
				
	      </div>
	    </div>

		

		</form>

	</div>
</body>
</html>