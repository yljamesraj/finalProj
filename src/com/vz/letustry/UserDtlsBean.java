package com.vz.letustry;

public class UserDtlsBean {
	private String userid;
	private String password;
	private String vzid;
	public String getUserid() {
		return userid;
	}
	public String getVzid() {
		return vzid;
	}
	public void setVzid(String vzid) {
		this.vzid = vzid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String role;
	

}
