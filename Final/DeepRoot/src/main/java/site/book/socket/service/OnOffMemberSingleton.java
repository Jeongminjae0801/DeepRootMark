package site.book.socket.service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @Class : ChatController.java
 * @Date : 2018. 6. 30.
 * @Author : 김태웅
 */
public class OnOffMemberSingleton {
	
	private static Map<String, Map<String, String>> online = new HashMap<>();
	
	public OnOffMemberSingleton() {}
	//Map<GID, Map<UID, "ON">>
	public static Map<String, Map<String, String>> getInstance () {
		return online;
	}
	
	public static String returnConvertJson(String gid){
		Gson gson = new Gson();
        String json = gson.toJson(online.get(gid));
        return json;
	}
}
