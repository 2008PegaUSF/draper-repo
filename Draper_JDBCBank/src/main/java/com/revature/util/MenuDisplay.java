package com.revature.util;

public class MenuDisplay {
	
	public void mainMenu() {
		System.out.println();
		System.out.println("Main Menu");
		System.out.println("=========");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Quit");
	}
	
	public void login() {
		System.out.println();
		System.out.println("Login");
		System.out.println("=====");
		System.out.println("Enter Credentials");
	}
	
	public void register() {
		System.out.println();
		System.out.println("Register");
		System.out.println("========");
		System.out.println("Enter New User Information");
	}
	
	public void createCustomer() {
		System.out.println();
		System.out.println("Create Customer");
		System.out.println("===============");
	}
	
	public void customerMenu() {
		System.out.println();
		System.out.println("Customer Menu");
		System.out.println("=============");
		System.out.println("1. Manage Accounts");
		System.out.println("2. Create New Account");
		System.out.println("3. Logout");
	}
	
	public void customerList() {
		System.out.println();
		System.out.println("Customer List");
		System.out.println("=============");
	}
	
	public void adminMenu() {
		System.out.println();
		System.out.println("Admin Menu");
		System.out.println("==========");
		System.out.println("1. Manage Users");
		System.out.println("2. Create New User");
		System.out.println("3. Logout");
	}
	
	public void accountMenu() {
		System.out.println("1. View History");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Close Account");
		System.out.println("5. Back");		
	}
	
	public void accountList() {
		System.out.println();
		System.out.println("Account List");
		System.out.println("============");
	}
	
	public void viewHistory() {
		System.out.println();
		System.out.println("Account History");
		System.out.println("===============");
	}

	public void manageCustomerMenu(String name) {
		System.out.println();
		System.out.println("Customer Menu - " + name);
		System.out.println("=============");
		System.out.println("1. Manage Accounts");
		System.out.println("2. Create New Account");
		System.out.println("3. Delete Customer");
		System.out.println("4. Back");
	}
}
