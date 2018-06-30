package site.book.socket.dto;

public class OnlineMemberDTO {
	private String uid;
	private String content;
	
	public String getUid() {return uid;}
	public void setUid(String uid) {this.uid = uid;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	@Override
	public String toString() {
		return "OnlineMemberDTO [uid=" + uid + ", content=" + content + "]";
	}
}
