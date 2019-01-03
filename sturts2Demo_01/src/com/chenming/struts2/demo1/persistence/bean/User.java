package com.chenming.struts2.demo1.persistence.bean;


public class User {
	private String username;  //用户名
	
	private String password; //密码
	
	private String Email;  //邮箱

	
	/* <================== Setter And Getter(Start) ===============> */
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
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	/* <================== Setter And Getter(End) ===============> */
}
