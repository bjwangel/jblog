package com.bit2016.jblog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private String description;
	private String reg_date;
	private Long users_no;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return reg_date;
	}
	public void setDate(String date) {
		this.reg_date = date;
	}
	public Long getBlog_no() {
		return users_no;
	}
	public void setUsers_no(Long blog_no) {
		this.users_no = blog_no;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", description=" + description + ", date=" + reg_date
				+ ", users_no=" + users_no + "]";
	}
	
	
}
