package com.springboot.bloggerapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	private int roleId;
	private boolean isActive;
	
	public User() {
		super();
	}

	public User(String username, String password, int roleId, boolean isActive) {
		super();
		this.username = username;
		this.password = getBycrptPassword(password);
		this.roleId = roleId;
		this.isActive = isActive;
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
		this.password = getBycrptPassword(password);
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ ", isActive=" + isActive + "]";
	}
	
	private String getBycrptPassword(String password) {
		BCryptPasswordEncoder bcryptPassword = new BCryptPasswordEncoder(12);
		return bcryptPassword.encode(password);
	}

}
