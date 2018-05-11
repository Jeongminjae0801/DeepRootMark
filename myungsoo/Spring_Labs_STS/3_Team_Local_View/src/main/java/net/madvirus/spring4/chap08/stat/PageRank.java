package net.madvirus.spring4.chap08.stat;

public class PageRank {
	
	private String rank;
	private String page;

	public PageRank(String rank, String page) {
		this.rank = rank;
		this.page = page;
	}

	public String getRank() {
		return rank;
	}

	public String getPage() {
		return page;
	}
	
}
