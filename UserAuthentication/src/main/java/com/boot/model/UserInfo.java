package com.boot.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5657234120535473053L;
	private String userName;
	private String password;
	private String role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
}
