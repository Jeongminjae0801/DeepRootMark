/*
 * @Project : DeepRoot
 * @FileName : ChatMessage.java
 * @Date : 2018. 6. 27.
 * @Author : 김희준
*/


package site.book.socket;

import java.time.LocalDateTime;

public class ChatMessage {
	private String nname;
	private String content;
	private LocalDateTime datetime;
	private String profile;
	
	// Getters and Setters
	public String getNname() {return nname;}
	public void setNname(String nname) {this.nname = nname;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public LocalDateTime getDatetime() {return datetime;}
	public void setDatetime(LocalDateTime datetime) {this.datetime = datetime;}
	public String getProfile() {return profile;}
	public void setProfile(String profile) {this.profile = profile;}
	
	@Override
	public String toString() {
		return "ChatMessage [nname=" + nname + ", content=" + content + ", datetime=" + datetime + ", profile="
				+ profile + "]";
	}
}
