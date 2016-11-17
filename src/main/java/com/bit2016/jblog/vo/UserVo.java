package com.bit2016.jblog.vo;

public class UserVo {
	private Long no;
	private String name;
	private String id;
	private String password;
	private String reg_date;
	

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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return reg_date;
	}
	public void setDate(String date) {
		this.reg_date = date;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", id=" + id + ", password=" + password + ", date=" + reg_date + "]";
	}
	
}
