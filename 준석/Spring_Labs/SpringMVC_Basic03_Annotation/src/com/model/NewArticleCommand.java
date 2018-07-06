package com.model;


public class NewArticleCommand {
	private int parentId;
	
	private String title;
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String content;
	@Override
	public String toString() {
		return "NewArticleCommand [parentId=" + parentId + ", title=" + title + ", content=" + content + "]";
	}
}
