package site.book.socket.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import site.book.socket.dto.SocketAlarmDTO;

/**
 * @Class : ChatController.java
 * @Date : 2018. 7. 2.
 * @Author : 김태웅
 */
@Controller
public class HeaderAlarmController {
	
	// Header, 소켓 통신: 초대/강퇴/완료 쪽지 수신
    @MessageMapping("/alarm/{nname}")
    @SendTo("/subscribe/alarm/{nname}")
    public SocketAlarmDTO sendOnlineMessage(@DestinationVariable("nname") String nname, @Payload SocketAlarmDTO alarm) throws Exception {
    	
    	System.out.println(alarm);

    	
        return alarm;
    }
    
}
