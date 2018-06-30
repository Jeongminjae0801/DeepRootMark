package site.book.socket;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import site.book.socket.service.OnOffMemberSingleton;
import site.book.user.service.UserService;

/**
 * @Class : ChatController.java
 * @Date : 2018. 6. 30.
 * @Author : 김태웅
 */
@Controller
public class ChatOnOffController {
	
	@Autowired
	private UserService userservice;
	
	// 채팅 메세지 전달
    @MessageMapping("/online/{room}")
    @SendTo("/subscribe/online/{room}")
    public List<String> sendChatMessage(@DestinationVariable("room") String room, String online_userid, SimpMessageHeaderAccessor headerAccessor, Principal principal) {
        
    	System.out.println("채팅방 ON");
    	// 온라인 유저 접속하면, Map(gid: [])에 추가
    	Map<String, List<String>> online_list = OnOffMemberSingleton.getInstance();
    	
    	// 해당 당의 온라인 유저에 추가
    	List<String> online_users = online_list.get(room);
    	online_users.add(online_userid);
    	
    	System.out.println(online_users);
    	// 다시 온라인 Map에 저장
    	online_list.put(room, online_users); 

        return online_users;
    }
    
	
  
}
