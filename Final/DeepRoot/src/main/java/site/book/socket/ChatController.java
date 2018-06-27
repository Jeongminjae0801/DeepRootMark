/*
 * @Project : DeepRoot
 * @FileName : ChatController.java
 * @Date : 2018. 6. 27.
 * @Author : 김희준
*/


package site.book.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
    /*@MessageMapping("/chat/{room}")
    @SendTo("/subscribe/chat/{room}")
    public ChatMessage sendChatMessage(@DestinationVariable("room") String room, ChatMessage message, SimpMessageHeaderAccessor headerAccessor, Principal principal, HttpServletRequest req) {
    	HttpSession session = req.getSession();
        String uid = (String)session.getAttribute("info_userid");
    	
        UserDTO user = userservice.getMember(uid);
        
        message.setNname(user.getNname());
        message.setDatetime(LocalDateTime.now());
        message.setProfile(user.getProfile());
        
        return message;
    }*/
	
}
