package com.revature.beans;

public class Transaction {
	private int transactionid;
	private String type;
	private float amount;
	private int accountid;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transactionid, String type, float amount, int accountid) {
		super();
		this.transactionid = transactionid;
		this.type = type;
		this.amount = amount;
		this.accountid = accountid;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", type=" + type + ", amount=" + amount + ", accountid="
				+ accountid + "]";
	}
}
