<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    	.test { background-color: #E0E3DA} 
    
    </style>
    
    
    <div id="content">
    	<div class="container">
    		<div class="row">
 <!-- 카테고리 div -->
    			<div class="col-lg-4 test" >
 					<!-- Root 카테고리 생성 버튼 -->
    				<button id="addroot">카테고리 추가</button>	
					<div id="jstree_container"></div>
    			</div>
    			
 <!-- 선택한 폴더(카테고리)의 URL -->   			
    			<div class="col-lg-5 test">
    				<!-- 선택한 폴더(카테고리)에서 url 추가 -->
    				<button id="testing">url add</button>
    				<div id="jstree_container_child"></div>
    			</div>
    			
    			
<!-- 내가 참여하는 그룹 리스트 -->
				<div class="col-lg-3 test">
					<div id="group_list"></div>
				</div>		    	
			</div>
		</div>
	</div>