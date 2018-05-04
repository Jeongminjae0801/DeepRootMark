<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>사원 관리</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Custom fonts for this template --> 
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/freelancer.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href="http://code.jquery.com/ui/1.12.1/themes/humanity/jquery-ui.css" rel="stylesheet">
    <link href="css/emp_table.css" rel="stylesheet" type="text/css">

    <!-- Custom scripts for this template -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="js/jquery.tablesorter.min.js"></script>

	
</head>
<body>
		<!-- Header 영역  -->
		<tiles:insertAttribute name="header" />
		<!--  Main 영역 -->
		<div id="main">
			<!-- Content 영역 -->
			<tiles:insertAttribute name="content" />
		</div>
		
		<!-- Footer  영역 -->
		<tiles:insertAttribute name="footer" />	
</body>
</html>