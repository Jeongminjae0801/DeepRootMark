


$(function() {
	// Header Alarm socket connect
	alarmConnect(userid);
	
	
});

//Header Alarm socket connect
function alarmConnect(userid) {
    // WebSocketMessageBrokerConfigurer의 registerStompEndpoints() 메소드에서 설정한 endpoint("/endpoint")를 파라미터로 전달
    var ws = new SockJS("/bit/endpoint");
    stompClient = Stomp.over(ws);
    stompClient.connect({}, function(frame) {
        // 메세지 구독
        // WebSocketMessageBrokerConfigurer의 configureMessageBroker() 메소드에서 설정한 subscribe prefix("/subscribe")를 사용해야 함
    	var user_nname = userid;
    	console.log(userid);
    	
        stompClient.subscribe('/subscribe/alarm/' + user_nname, function(message) {
        	
        	var recv_alarm = JSON.parse(message.body);
        	console.log(recv_alarm);
        	
        });
    }, 
    function(message) {
        stompClient.disconnect();
    });
    ws.onclose = function() {
    	alarmDisconnect();
        location.href = "/bit/index.do";
    };
}

//Header Alarm socket disconnect
function alarmDisconnect() {
    stompClient.disconnect();
}