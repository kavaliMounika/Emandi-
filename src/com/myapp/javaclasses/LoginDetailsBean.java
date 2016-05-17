package com.myapp.javaclasses;

public class LoginDetailsBean {

	private String userName;
	private String password;
	private int roleId;
	private int userId;
	
	
	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



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



	public LoginDetailsBean() {
		// TODO Auto-generated constructor stub
	}

}
