<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>

<script>
	/* Chatting Start */
	var stompClient = null;
	var gid = '<c:out value="${gid}"/>';
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
	        	console.log(message.body);
	            /* var data = JSON.parse(message.body);
	            alert(data.nname + ":" + data.content); */
	        });        
	    });
	    
	}
	 
	// 채팅 메세지 전달
	function sendMessage() {
		console.log("click");
		
	    var str = $("#chatt_input").val();
	    str = str.replace(/ /gi, '&nbsp;')
	    str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
	    console.log(str);
	    if(str.length > 0) {
	        // WebSocketMessageBrokerConfigurer의 configureMessageBroker() 메소드에서 설정한 send prefix("/")를 사용해야 함
	        stompClient.send("/socket/chat/" + gid, {}, JSON.stringify({
	           	content: str
	        }));
	    }
	    $("#chatt_input").val('');
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
          	채팅창 영역
          	<div id="chatt-atea">
          	
          	</div>
          	
          	<div id="chatt-input">
          		<ol class="list-inline">
          			<li><img class="chatt-profile" src="<%= request.getContextPath() %>/images/profile/${sessionScope.info_userprofile}" onerror="<%= request.getContextPath() %>/images/profile.png">
          			<li>
          				<ul class="chatt-content-area">
          					<li>${sessionScope.info_usernname}</li>
          					<li>채팅내용 블라블라블라</li>
          				</ul>		
          			</li>
          		</ol>
          	</div>
          	
          	<div class="row">
          		<input id="chatt_input" type="text">
          		<button type="button" id="sendBtn" class="btn btn-default">전송</button>
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