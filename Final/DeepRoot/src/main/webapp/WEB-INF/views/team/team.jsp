<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>

<script>
	/* Chatting Start */
	var stompClient = null;
	var gid = '<c:out value="${gid}"/>';
	var nname = '<c:out value="${nname}"/>';
	var profile = '<c:out value="${profile}"/>';
	
	console.log(gid);
	$(function(){
		connect();
		
		$('#chatt-input').keypress(function(event) {
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if (keycode == '13') {
				sendMessage();
			}
			event.stopPropagation();
		});
		$('#sendBtn').click(function() {
			sendMessage();
		});
	});
	
	// 채팅방 연결
	function connect() {
	    console.log("connect");
	    // WebSocketMessageBrokerConfigurer의 registerStompEndpoints() 메소드에서 설정한 endpoint("/endpoint")를 파라미터로 전달
	    var ws = new WebSocket("ws://192.168.0.21:8090/bit/endpoint");
	    stompClient = Stomp.over(ws);
	    stompClient.connect({}, function(frame) {
	        // 메세지 구독
	        // WebSocketMessageBrokerConfigurer의 configureMessageBroker() 메소드에서 설정한 subscribe prefix("/subscribe")를 사용해야 함
	        stompClient.subscribe('/subscribe/chat/' + gid, function(message) {
	        	//console.log(message.body);
	        	
	        	var new_chat = JSON.parse(message.body);
	        	//console.log(new_chat.nname);
	        	var chat_div = "";
	        	chat_div += '<img class="chatting_profile_img" src="${pageContext.request.contextPath}/images/profile/' + new_chat.profile + '">';
	        	chat_div += '<div class="chatting_text_div">';
	        	chat_div += '<p class="chatting_userid">';
	        	chat_div += new_chat.nname + '<span class="chatting_time">' + new_chat.datetime + '</span>';
	        	chat_div += '</p>';
	        	chat_div += '<span class="chatting_text">';
                chat_div += new_chat.content;
                chat_div += '</span>';
                chat_div += '</div>';  	

                console.log(chat_div);
                $(".chatting_contents").append(chat_div);
	        	
	        });        
	    });
	    
	}
	 
	// 채팅 메세지 전달
	function sendMessage() {
		console.log("click");
		
	    var str = $("#chat_textbox_text").text();
	    str = str.replace(/ /gi, '&nbsp;')
	    str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
	    console.log(str);
	    if(str.length > 0) {
	        // WebSocketMessageBrokerConfigurer의 configureMessageBroker() 메소드에서 설정한 send prefix("/")를 사용해야 함
	        stompClient.send("/socket/chat/" + gid, {}, JSON.stringify({
	           	content: str,
	           	nname: nname,
	           	profile: profile
	        }));
	    }
	}
	 
	// 채팅방 연결 끊기
	function disconnect() {
	    stompClient.disconnect();
	}

	/* Chatting End */

</script>

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
          	<div class="chat_content_div">
	            <div class="chat_element">
	                <!-- 날짜 변경되면 나오는 친구 -->
	                <div class="divider"><hr class="left"/><span>today</span><hr class="right"/></div>
	                <div class="chatting_contents">
	                    <img class="chatting_profile_img" src="https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg">
	
	                    <div class="chatting_text_div">
	                        <p class="chatting_userid">
	                           	정민재 <span class="chatting_time">12시 27분</span>
	                        </p>
	                        <span class="chatting_text">
					                            희준이는 토게피<br>
					                            아니 채팅창을 만들어본적이 없는데 어떻게 만들란 거야?? 응???
	                        </span>
	                    </div>
	                    
	                    <img class="chatting_profile_img" src="https://s3.amazonaws.com/uifaces/faces/twitter/GavicoInd/128.jpg">
	
	                    <div class="chatting_text_div">
	                        <p class="chatting_userid">
	                           	정민재 <span class="chatting_time">12시 27분</span>
	                        </p>
	                        <span class="chatting_text">
					                            희준이는 토게피<br>
					                            아니 채팅창을 만들어본적이 없는데 어떻게 만들란 거야?? 응???
	                        </span>
	                    </div>
	                </div>
	            </div>
	
	            <div class="chat_inputbox_div">
	                <div class="chat_inputbox_bg">
	                    <div class="chat_textbox">
	                        <div id="chat_textbox_text">
	
	                        </div>
	                        <div id="chat_textbox_icon">
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