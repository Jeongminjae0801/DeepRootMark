<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		
		<!-- CSS Files -->
		<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Raleway' />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css" />
  		<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' />
  
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/main.css" />
		<link rel="stylesheet" href="css/animate.css" />
		<link rel="stylesheet" href="css/owl.carousel.css" />
		<link rel="stylesheet" href="css/owl.theme.css" />
		<link rel="stylesheet" href="css/responsive.css" />
		<link rel="stylesheet" href="css/style.css" />
		
		<!-- Fonts icons -->
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		
	</head>
	
	<body>
		<!-- Header 영역  -->
		<tiles:insertAttribute name="header" />
		<!-- Main 영역 -->
		<div id="main">
			<div class="top-wrapper clear">
				<!-- Content 영역 -->
				<tiles:insertAttribute name="content" />
			</div>
		</div>
		
		<!-- Footer 영역 -->
		<tiles:insertAttribute name="footer" />
		
		<!-- jQuery first, then Tether, then Bootstrap JS. -->
		<script src="js/jquery.min.js"></script>
		<script src="js/tether.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/owl.carousel.min.js"></script>
		<script src="js/form-validator.min.js"></script>
		<script src="js/contact-form-script.js"></script>
		<script src="js/main.js"></script>
	</body>
	
	
</html>
