<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<style>
#navbarcss {
	font-family: Montserrat, sans-serif;
	margin-bottom: 0;
	background-color: #e5faf5;
	border: 10px;
	font-size: 10px !important;
	letter-spacing: 4px;
	opacity: 0.9;
}
navbar li a, .navbar a {
	color: #000000 !important;
}
.navbar-default .navbar-toggle {
	border-color: #3e9c9d !important;
}
.navbar-collapse {
	border-color: #e5faf5 !important;
}
.icon-bar {
	background-color: #3e9c9d !important;
}
.navbar-default .navbar-toggle:focus, .navbar-default .navbar-toggle:hover
	{
	background-color: #e5faf5 !important;
}
#myNavbar ul {
	list-style: none;
	font-family: Helvetica, Arial, sans-serif;
	font-size: 24px;
	letter-spacing: -2px;
	line-height: 1.2em;
	float: left;
	border: 5px solid #e5faf5;
}
#myNavbar ul li a {
	display: block;
	text-decoration: none;
	padding: 5px 10px 5px 10px;
	background-color: #e5faf5;
	width: 170px;
	border-left: 6px solid #000000;
}
#myNavbar ul li a span {
	display: block;
}
#myNavbar ul li a span.title {
	color: #000000;
}
#myNavbar ul li a:hover {
	border-left: 6px solid #3e9c9d;
}
#myNavbar ul li a:hover span.title {
	color: #3e9c9d;
}
#myNavbar ul li a span.text {
	padding: 0px 5px;
	font-size: 8px;
	font-style: italic;
	font-weight: normal;
	letter-spacing: normal;
	line-height: 1.4em;
	visibility: hidden;
	color: #3e9c9d;
	text-align: right;
	border-top: 5px solid #3e9c9d;
}
#myNavbar ul li a:hover span.text {
	visibility: visible;
}
</style>

<!-- navbar -->
<nav class="navbar navbar-default" id="navbarcss">
	<div class="container-fluid" style="clear: both; margin: 20px;">
		<div class="navbar-header">
			<a href="main.htm" style="text-decoration: none">
				<i class="fab fa-skyatlas fa-4x" style="float: left; color: #3e9c9d;"></i>&nbsp;
				<b style="href-style: none; font-size: 30px; color: #3e9c9d;">DB</b>
			</a>

			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="contentWrite.htm" id="a1"><span class="title">글작성하기</span></a></li>
				<li><a href="contentList.htm" id="a2"><span class="title">글목록보기</span></a></li>
				<li><a href="contentEdit.htm" id="a2"><span class="title">글수정하기</span></a></li>
				<li><a href="loginform.htm" id="a7"><span class="title">회원가입</span></a></li>
				<li><a href="login.htm" id="a8"><span class="title">로그인</span></a></li>
			</ul>
		</div>
	</div>
</nav>
