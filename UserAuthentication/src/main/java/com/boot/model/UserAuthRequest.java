package com.boot.model;

import java.io.Serializable;

public class UserAuthRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3871288328822246348L;
	private String username;
	private String password;
	private String email;
	private long contact;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
}
