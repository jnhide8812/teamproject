package com.shop.dto;

public class UsersVO {
	private String id;
	private String upwd;
	private String uname;
	private String uphone;
	private String ubirth;
	private String uaddress;
	private String ugrade;
	private int upoint;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUbirth() {
		return ubirth;
	}
	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUgrade() {
		return ugrade;
	}
	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	@Override
	public String toString() {
		return "UsersVO [id=" + id + ", upwd=" + upwd + ", uname=" + uname + ", uphone=" + uphone + ", ubirth=" + ubirth
				+ ", uaddress=" + uaddress + ", ugrade=" + ugrade + ", upoint=" + upoint + "]";
	}

}
