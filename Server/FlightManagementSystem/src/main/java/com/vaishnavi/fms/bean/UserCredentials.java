package com.vaishnavi.fms.bean;

public class UserCredentials {

	private String username;

	private String password;

	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCredentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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
}
