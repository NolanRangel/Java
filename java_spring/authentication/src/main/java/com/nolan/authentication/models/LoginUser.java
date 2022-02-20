package com.nolan.authentication.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class LoginUser {
	
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be at least 8 characters, include 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.")
    private String password;
    
    public LoginUser() {}

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
