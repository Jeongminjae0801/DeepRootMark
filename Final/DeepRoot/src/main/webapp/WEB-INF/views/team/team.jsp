<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
    
<!-- body TOP div START -->
<section class="my">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
              
                     위에 뭐가 뜨는 영역

            </div>
        </div>
    </div>    
</section>
<!-- body TOP div END -->

<!-- body Middle Content START -->
<div class="container-fluid">
    <div class="row">
        <!-- Group Category div START -->
        <section class="col-sm-4 group-category">    
            Jstree 북마크 영역
        </section>
        <!-- Group Category div END -->
        
        <!-- Group Chart div START -->
        <section class="col-sm-5 chatt">
          	<div class="chat-content-div">
	            <div class="chat-element">
	                <!-- 날짜 변경되면 나오는 친구 -->
	                <div class="divider"><hr class="left"/><span>today</span><hr class="right"/></div>
	                <div class="chatting-contents">
	                    <img class="chatting-profile-img" src="https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg">
	
	                    <div class="chatting-text-div">
	                        <p class="chatting-userid">
	                           	정민재 <span class="chatting-time">12시 27분</span>
	                        </p>
	                        <span class="chatting-text">
					                            희준이는 토게피<br>
					                            아니 채팅창을 만들어본적이 없는데 어떻게 만들란 거야?? 응???
	                        </span>
	                    </div>
	                </div>
	            </div>
	
	            <div class="chat-inputbox-div">
	                <div class="chat-inputbox-bg">
	                    <div class="chat-textbox">
	                        <div id="chat-textbox-text">
	
	                        </div>
	                        <div id="chat-textbox-icon">
	                            <i class="fas fa-share-square"></i>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
          	
        </section>
        <!-- Group Chart div END -->
        
        <!-- Group Member div START -->
        <section class="col-sm-3 group-member">
            <c:forEach items="${gmemberlist}" var="gmember">
            	<p>${gmember.nname}</p>           
            
            </c:forEach>
        </section>
        <!-- Group Member div END -->
        
    </div>
</div>
<!-- body Middle Content END -->