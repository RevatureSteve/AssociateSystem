package com.revature.dto;

import java.io.Serializable;

public class AuthenticationDTO implements Serializable {

	private static final long serialVersionUID = -8247161533905914779L;
	
	private String username;
	private String password;
	
	public AuthenticationDTO(){}

	public AuthenticationDTO(String username, String password) {
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

	@Override
	public String toString() {
		return "AuthenticationDTO [username=" + username + ", password=" + password + "]";
	}
	
}
