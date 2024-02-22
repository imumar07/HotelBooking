package com.example.Entity;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private int userId;
	private String username;
	private String password;
	private String email;
	private String userType;
	private String phoneNumber;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return this.userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phone) {
		this.phoneNumber = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String username, String password, String email, String userType, String phoneNumber,
			String name) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", userType=" + userType + ", phoneNumber=" + phoneNumber + ", name=" + name + "]";
	}


	
}
