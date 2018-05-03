<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		
		<div id="Carousel" class="carousel slide carousel-fade" data-ride="carousel"> 
	
			<!--페이지-->
			<ol class="carousel-indicators">
				<li data-target="#Carousel" data-slide-to="0" class="active"></li>
				<li data-target="#Carousel" data-slide-to="1"></li>
				<li data-target="#Carousel" data-slide-to="2"></li>
				<li data-target="#Carousel" data-slide-to="3"></li>
				<li data-target="#Carousel" data-slide-to="4"></li>
			</ol>
			<!--페이지-->
		
			<div class="carousel-inner">
				<!--슬라이드1-->
				<div class="item active"> 
					<img class="img-responsive" src="images/7.jpg" style="width:100%; max-height: 700px" alt="First slide">
				</div>
				<!--슬라이드1-->
							
				<div class="item"> 
					<img class="img-responsive" src="images/5.jpg" style="width:100%; max-height: 700px" alt="First slide">
				</div>
				<div class="item"> 
					<img class="img-responsive" src="images/6.jpg" style="width:100%; max-height: 700px" alt="First slide">
				</div>
				<div class="item"> 
					<img class="img-responsive" src="images/8.jpg" style="width:100%; max-height: 700px" alt="First slide">
				</div>
				<div class="item"> 
					<img class="img-responsive" src="images/9.jpg" style="width:100%; max-height: 700px" alt="First slide">
				</div>
			</div>
			
			<!--이전, 다음 버튼-->
			<a class="left carousel-control" href="#Carousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> 
			<a class="right carousel-control" href="#Carousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a> 
		</div>

	    <!-- chart -->
	   <div id="container" style="min-width: 310px; height: 400px; margin-top: 70px; padding : 0px 120px 120px 120px !important;"></div>
		<!--  region -->
		
		<div class="container text-center" style="min-width: 310px; padding : 0px 120px 120px 120px !important;">
		<div style="padding-top : 70px !important;"><b><h2>REGION</h2></b><b><h4>원하는 지역을 고르세요!</h4></b></div>
		    <div class="row">
		        <div class="col-sm-12">
		        	<br>
		        	<div id="seoul" style="position:relative; top:92px; left:-278px;"><b>서울특별시</b></div>
		       	    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
		        	<div class="mapArea" style="width:100%; height:100%;">
		        	 	<div id="locName" style="width:100%; position:relative; top:92px; left:-278px;"><a></a></div>
					    <div class="paper" id="paper" style="width:100%; height:100%;"></div>
					</div>
		        </div>
		    </div>
		</div>
		
		
		<!--  theme -->
		<div style="background-color:#bafcea;">
			<div class="container text-center" style="background-color:#bafcea; padding : 0px 120px 120px 120px !important;">
			<div style="padding-top : 70px !important; padding-bottom : 70px !important;"><b><h2>THEME</h2></b><b><h4>원하는 테마를 고르세요!</h4></b></div>
				
				<div class="row" id="click">
				    <div class="col-sm-4">
				     <a><span value="thema.db?tnum=1&tname=운동" class="fas fa-bicycle fa-5x pic" style="color:#000;"></span></a>
					  <br><br>
				     <p class="text-center" style="font-size:25px; color:#000;">운동</p>
				     <p class="text-center" style="font-size:15px; color:#000;">exercise</p>
				    </div>
				    <div class="col-sm-4">
				      <a><span value="thema.db?tnum=2&tname=야경" class="fas fa-moon fa-5x" style="color:#000;"></span></a>
				      <br><br>
					  <p class="text-center" style="font-size:25px; color:#000;">야경</p>
					  <p class="text-center" style="font-size:15px; color:#000;">night scene</p>
				    </div>
				    <div class="col-sm-4">
				     <a><span value="thema.db?tnum=3&tname=놀이" class="fab fa-fort-awesome fa-5x" style="color:#000;"></span></a>
				     <br><br>
				     <p class="text-center" style="font-size:25px; color:#000;">놀이</p>
				     <p class="text-center" style="font-size:15px; color:#000;">game</p>
				    </div>
				    <div class="col-sm-4">
				      <a><span value="thema.db?tnum=4&tname=식당" class="fas fa-utensils fa-5x" style="color:#000;"></span></a>
				      <br><br>
				   	  <p class="text-center" style="font-size:25px; color:#000;">식당</p>
				   	  <p class="text-center" style="font-size:15px; color:#000;">restaurant</p>
				    </div>
				    <div class="col-sm-4">
				      <a><span value="thema.db?tnum=5&tname=꽃놀이" class="fab fa-pagelines fa-5x" style="color:#000;"></span></a>
					  <br><br>
				      <p class="text-center" style="font-size:25px; color:#000;">꽃놀이</p>
				      <p class="text-center" style="font-size:15px; color:#000;">flower viewing</p>
				    </div>
				    <div class="col-sm-4">
				      <a><span value="thema.db?tnum=6&tname=등산" class="fas fa-tree fa-5x" style="color:#000;"></span></a>
				      <br><br>
				      <p class="text-center" style="font-size:25px; color:#000;">등산</p>
				      <p class="text-center" style="font-size:15px; color:#000;">climing</p>
				    </div>
				</div>
			</div>
		</div>
