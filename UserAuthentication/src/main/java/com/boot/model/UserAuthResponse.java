package com.boot.model;

import java.io.Serializable;

public class UserAuthResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5738625683155930123L;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}