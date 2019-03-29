package com.revature.dto;


public class LoginUser {
	private String userName;
	private String password;
	
	public LoginUser() {
		super();
	}
	public LoginUser(String user, String password) {
		this.userName = user;
		this.password = password;
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
	@Override
	public String toString() {
		return "LoginUser [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
