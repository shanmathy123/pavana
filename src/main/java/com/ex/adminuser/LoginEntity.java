package com.ex.adminuser;

import javax.persistence.Entity;


public class LoginEntity {

    private String email;
	private String password;
	
	public LoginEntity() {}

	public LoginEntity(String email, String password) {
		super();
		this.email= email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
