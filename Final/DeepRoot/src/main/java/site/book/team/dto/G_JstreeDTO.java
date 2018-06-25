package site.book.team.dto;

public class G_JstreeDTO {
	private int id;
	private String uid;
	private String parent;
	private String text;
	private String icon;
	
	public G_JstreeDTO() {}
	public G_JstreeDTO(int id, String uid, String parent, String text, String icon) {
		this.id = id;
		this.uid = uid;
		this.parent = parent;
		this.text = text;
		this.icon = icon;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getUid() { return uid; }
	public void setUid(String uid) { this.uid = uid; }
	public String getParent() { return parent; }
	public void setParent(String parent) { this.parent = parent; }
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
	public String getIcon() { return icon; }
	public void setIcon(String icon) { this.icon = icon;}

	@Override
	public String toString() {
		return "G_JstreeDTO [id=" + id + ", uid=" + uid + ", parent=" + parent
				+ ", text=" + text + ", icon=" + icon + "]";
	} 
}
