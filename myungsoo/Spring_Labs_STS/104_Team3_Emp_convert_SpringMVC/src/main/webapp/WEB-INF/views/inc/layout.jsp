<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> -->
	<title>INDEX</title>
	
	 <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="css/freelancer.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href="http://code.jquery.com/ui/1.12.1/themes/humanity/jquery-ui.css" rel="stylesheet">
    <link href="css/3group.css" rel="stylesheet">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
  
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
	<script type="text/javascript">
	$(document).ready( function () {
	    $('#tab').DataTable();
	} );
	</script>
	
	
</head>
<body id="page-top">

	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="visual" />
		
	
		<!--  Main 영역 -->
		<div id="main">
			<!-- Content 영역 -->
			<tiles:insertAttribute name="content" />
		</div>
		
		<!-- Footer  영역 -->
		<tiles:insertAttribute name="footer" />	
</body>
</html>