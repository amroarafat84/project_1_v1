package com.revature.dto;


public class LoginUser {
	private String userName;
	private String password;
	private int type;
	
	public LoginUser() {
	}
	public LoginUser(String user, String password, int type) {
		this.userName = user;
		this.password = password;
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "LoginUser [userName=" + userName + ", password=" + password + ", flag=" + type + "]";
	}
	
	
}
