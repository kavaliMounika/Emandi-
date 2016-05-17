/**
 * 
 */
package com.myapp.actionForm;

import org.apache.struts.action.ActionForm;

/**
 * @author Mouniprasad
 *
 */
public class LoginDetailsActionForm extends org.apache.struts.action.ActionForm {

	/**
	 * 
	 */
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


	public LoginDetailsActionForm() {
		// TODO Auto-generated constructor stub
	}

}
