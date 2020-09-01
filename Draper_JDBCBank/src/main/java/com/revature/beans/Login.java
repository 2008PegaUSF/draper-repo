package com.revature.beans;

public class Login {
	private String username;
	private String password;
	private String type;
	private int customerid;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String username, String password, String type, int customerid) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
		this.customerid = customerid;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", type=" + type + ", customerid="
				+ customerid + "]";
	}
}
