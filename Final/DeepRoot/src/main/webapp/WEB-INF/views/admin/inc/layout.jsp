<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel=stylesheet href=https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css>
    <link rel=stylesheet href=https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css>
    
    <!-- CSS START -->
    <link rel="stylesheet" href="../css/admin/bootstrap.min.css">
    <link rel="stylesheet" href="../css/admin/AdminLTE.css">
    <link rel="stylesheet" href="../css/admin/skin.css">
    <link rel="stylesheet" href="../css/admin/pace.css">
    <link rel="stylesheet" href="../css/admin/app.css">
    <link rel="stylesheet" href="../css/admin/pagetransition.css">
    <!-- CSS END -->
    
    <!-- Script START -->
    <script src="../js/jquery.js"></script>
    <!-- Script END -->

    <!--CHART Resources START-->
    <script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
    <script src="https://www.amcharts.com/lib/3/serial.js"></script>
    <script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <script src="https://www.amcharts.com/lib/3/themes/dark.js"></script>
    <!--CHART Resources END-->
    
<title>뿌리깊은마크 관리자 페이지</title>
</head>
<body class="skin-blue sidebar-mini pace-done" style="overflow-y:scroll">
	<div id="main-header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<div id="main">
		<tiles:insertAttribute name="content" />
	</div>
	
	<div id="main-footer">
		<tiles:insertAttribute name="footer" />
	</div>
	
	<!-- Script START -->
    <script async="" src="https://www.google-analytics.com/analytics.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/admin/app.min.js"></script>
    <script src="../js/admin/pace.js"></script>
    <script src="//d2wy8f7a9ursnm.cloudfront.net/v4/bugsnag.min.js"></script>
    <script src="//d2wy8f7a9ursnm.cloudfront.net/bugsnag-plugins/v1/bugsnag-vue.min.js"></script>
    <!-- Script END -->
</body>
</html>