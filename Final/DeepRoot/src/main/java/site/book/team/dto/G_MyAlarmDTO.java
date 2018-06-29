package site.book.team.dto;

public class G_MyAlarmDTO {
	private String toid;
	private String fromid;
	private String gname;
	private String ganame;
	private String senddate;
	
	public G_MyAlarmDTO() {	}
	public G_MyAlarmDTO(String toid, String fromid, String gname, String ganame, String senddate) {
		this.toid = toid;
		this.fromid = fromid;
		this.gname = gname;
		this.ganame = ganame;
		this.senddate = senddate;
	}
	
	public String getToid() {return toid;}
	public void setToid(String toid) {this.toid = toid;}
	public String getFromid() {return fromid;}
	public void setFromid(String fromid) {this.fromid = fromid;}
	public String getGname() {return gname;}
	public void setGname(String gname) {this.gname = gname;}
	public String getGaname() {return ganame;}
	public void setGaname(String ganame) {this.ganame = ganame;}
	public String getSenddate() {return senddate;}
	public void setSenddate(String senddate) {this.senddate = senddate;}
	
	@Override
	public String toString() {
		return "G_MyAlarmDTO [toid=" + toid + ", fromid=" + fromid + ", gname=" + gname + ", ganame=" + ganame
				+ ", senddate=" + senddate + "]";
	}
}
