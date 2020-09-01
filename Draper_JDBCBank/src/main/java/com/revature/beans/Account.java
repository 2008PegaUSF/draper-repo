package com.revature.beans;

public class Account {
	private int accountid;
	private float balance;
	private int customerid;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(int accountid, float balance, int customerid) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.customerid = customerid;
	}
	
	public int getAccountid() {
		return accountid;
	}
	
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	
	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public int getCustomerid() {
		return customerid;
	}
	
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + ", customerid=" + customerid + "]";
	}
}
