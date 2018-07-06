<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>      
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<!-- title 영역 -->
		<tiles:getAsString name="title" />
	</title>
		<!-- css 영역 -->
		<link href='<tiles:getAsString name="css" />' type="text/css" rel="stylesheet">
		<script src="//code.jquery.com/jquery.min.js"></script>
			<script type="text/javascript">
		$(document).ready(function(){
			var idck=1;
			console.log("button");
		/* 	
			function keyup(){
				idck=1;
			}; */
			
			
			$('#btnCheckUid').click(function(){
				
				var input_id = $('#userid').val();
				if(input_id == "" || $.trim(input_id)==""){
						alert("아이디를 입력해주세요");
						$('#userid').val(""); 
						 $('#userid').focus();
						return false;
					
				}
				
				 $.ajax(
						 {
							type : "post",
							url  : "idcheck.htm",
							dataType: "json",
							data : "userid=" + input_id,
							success : function(data){
								
								console.log(data);
								alert("success");
								alert(data);
								
								
					 			if(data=="0"){
					 				alert("사용가능한 아이디 입니다.");
									idck =0;
									$('#pwd').focus();
									
								}else{
									alert("이미 사용중인 아이디 입니다.");
									$('#userid').val("");
									$('#userid').focus();
									
								} 
												
							} 
						 } 
				       )    
				});
			
/* 			
			$('#submit').on("click",function(){
				alert("중복")
				console.log(idck);
				if(idck==1){
					alert("중복 체크를 해주세요")
					return false;					
				}else{
					alert("제출");
					$('#submit').submit();
				}
				
			}) */
		});
		</script>
		
		
</head>
<body>
		<!-- Header  영역 -->
		<tiles:insertAttribute name="header" />
		<!-- Visual 영역 -->
		<tiles:insertAttribute name="visual" />
		<div id="main">
			<div class="top-wrapper clear">
				 <!-- Content 영역 -->
				 <tiles:insertAttribute name="content" />
				 <!-- Aside  영역 -->
				 <tiles:insertAttribute name="aside" />
			</div>
		</div>
		
		<!-- Footer 영역 -->
		<tiles:insertAttribute name="footer" />
		
</body>
</html>