package site.book.socket.dto;

import java.util.List;

public class OnlineMemberDTO {
	private List<String> online_list;
	
	public OnlineMemberDTO() {}
	public OnlineMemberDTO(List<String> online_list) {
		this.online_list = online_list;
	}
	public List<String> getOnline_list() {return online_list;}
	public void setOnline_list(List<String> online_list) {this.online_list = online_list;}
	
	@Override
	public String toString() {
		return "OnlineMemberDTO [online_list=" + online_list + "]";
	}
}
