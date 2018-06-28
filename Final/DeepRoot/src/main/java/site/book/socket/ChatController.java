/*
 * @Project : DeepRoot
 * @FileName : ChatController.java
 * @Date : 2018. 6. 27.
 * @Author : 김희준
*/


package site.book.socket;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import site.book.user.dto.UserDTO;
import site.book.user.service.UserService;

/**
 * @Class : ChatController.java
 * @Date : 2018. 6. 27.
 * @Author : 김희준
 */
@Controller
public class ChatController {
	
	@Autowired
	private UserService userservice;
	
	// 채팅 메세지 전달
    @MessageMapping("/chat/{room}")
    @SendTo("/subscribe/chat/{room}")
    public ChatMessage sendChatMessage(@DestinationVariable("room") String room, ChatMessage message, SimpMessageHeaderAccessor headerAccessor, Principal principal) {
        
    	message.setDatetime(LocalTime.now().getHour() + "시 " + LocalTime.now().getMinute() + "분");
    	
        return message;
    }
	
    
    //명수
    //jstree 변경 메시
}
