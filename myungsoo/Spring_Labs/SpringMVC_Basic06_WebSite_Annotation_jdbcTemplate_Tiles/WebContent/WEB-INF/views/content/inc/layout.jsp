
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<title>
		<!-- title 영역 -->
		<tiles:getAsString name="title" />
	</title>
</head>
<body>
		<!-- Header  영역 -->
	 	<tiles:insertAttribute name="header" /> 
		<div id="main">
			<div class="container">
				 <!-- Content 영역 -->
				 <tiles:insertAttribute name="content" />
			</div>
		</div>
		
		<!-- Footer 영역 -->
		<tiles:insertAttribute name="footer" /> 
</body>
</html>