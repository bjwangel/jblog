package com.bit2016.jblog.vo;

public class BlogVo {
	private Long no;
	private String title="기본 타이틀";
	private String logo="기본 로고";
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "BlogVo [no=" + no + ", title=" + title + ", logo=" + logo + "]";
	}
	
	
	
}
