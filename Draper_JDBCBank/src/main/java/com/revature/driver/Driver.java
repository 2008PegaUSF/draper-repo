package com.revature.driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Login;
import com.revature.beans.Transaction;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.daoimpl.LoginDaoImpl;
import com.revature.daoimpl.TransactionDaoImpl;
import com.revature.util.MenuDisplay;

public class Driver {
	
	// Members
	private CustomerDaoImpl cdi; //DAO Implementations
	private AccountDaoImpl adi;
	private TransactionDaoImpl tdi;
	private LoginDaoImpl ldi;
	
	private MenuDisplay display;
	
	private Customer customer;
	
	private Scanner input;
	
	// Constructor
	public Driver() {
		cdi = new CustomerDaoImpl();
		adi = new AccountDaoImpl();
		tdi = new TransactionDaoImpl();
		ldi = new LoginDaoImpl();
		
		display = new MenuDisplay();
		
		customer = null;
		
		input = new Scanner(System.in);
	}
	
	/*
	 * Generic Functionality
	 */
	
	public void login() {
		List<Login> logins = null;//Get a list of every login
		try {
			logins = ldi.getAllLogins();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		display.login();
		
		while(true) {
			System.out.print("Username: ");//Get the users login information
			String username = input.next();
			System.out.print("Password: ");
			String password = input.next();
			
			for (Login l : logins) {//Compare user info with login list
				if (username.equals(l.getUsername()) && password.equals(l.getPassword())) {
					System.out.println("Login Success.");
					userPortal(l);
					return;
				}
			}
			
			System.out.println("Invalid credentials. Try again? (Y/N)");
			String option = input.next();
			if (!option.equals("Y")) {
				return;
			}
		}
	}
	
	public void userPortal(Login l) {//This directs the program accordingly, depending on customer or admin login
		if (l.getType().equals("Customer")) {
			try {
				customer = cdi.getCustomerByCustomerID(l.getCustomerid());
				System.out.println("Welcome, " + customer.getFirstname() + "!");
				customerMenu();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Welcome, Admin!");
			customer = null;
			adminMenu();
		}
	}
	
	/*
	 * Customer Functionality 
	 */
	
	public void register() {
		List<Login> logins = null;//Get a list of every login
		try {
			logins = ldi.getAllLogins();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		display.register();
		
		System.out.print("Username: ");//Get the users login information
		String username = input.next();
		System.out.print("Password: ");
		String password = input.next();
		System.out.print("First Name: ");
		String firstName = input.next();
		System.out.print("Last Name: ");
		String lastName = input.next();
		
		for (Login l : logins) {//Compare user info with login list
			if (username.equals(l.getUsername())) {
				System.out.println("This username is already taken. Reverting to main menu");
				return;
			}
		}
		
		try { //Create account
			ldi.createNewLogin(username, password); // Create login record
			cdi.createNewCustomer(firstName, lastName); // Create new customer
			customer = cdi.getLastCustomer();// Get the new customer
			int id = customer.getCustomerid();// Get the id of the new customer
			ldi.updateLoginCustomerID(username, id);// Attach the customer to the new login
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Registration Success.");
		System.out.println("Welcome, " + firstName + "!");
		
	}
	
	public void selectAccount() {//The user chooses which account to manage here
		List<Account> accounts = null;
		try {
			accounts = adi.getAllAccountsByCustomerID(customer.getCustomerid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		display.accountList();
		
		for(Account a : accounts) {
			System.out.println(a.getAccountid());
		}
		
		while (true) {
			System.out.print("Choose an account: ");
			int choice = input.nextInt();
			
			for (Account a : accounts) {
				if (a.getAccountid() == choice) {
					manageAccount(a);
					return;
				}
			}
			
			System.out.println("Invalid choice. Try again? (Y/N)");
			String option = input.next();
			if (!option.equals("Y")) {
				return;
			}
		}
	}
	
	public void viewHistory(Account account) {// View every transaction referencing this account
		display.viewHistory();
		
		List<Transaction> history = null;
		try {
			 history = tdi.getAllTransactionByAccountID(account.getAccountid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (Transaction t : history) {
			System.out.println(t.getType() + " $" + t.getAmount());
		}
	}
	
	public void deposit(Account account) {
		System.out.println();
		System.out.print("Enter Deposit Amount: ");
		float deposit = input.nextFloat();
		
		try {
			adi.updateAccountBalance(deposit, account.getAccountid());
			tdi.createNewTransaction("Deposit", deposit, account.getAccountid());
			account.setBalance(account.getBalance() + deposit);
			System.out.println("Successful Deposit: $" + deposit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void withdraw(Account account) {
		System.out.println();
		System.out.print("Enter Withdrawal Amount: ");
		float withdrawal = input.nextFloat();
		
		if (withdrawal <= account.getBalance()) {
			try {
				adi.updateAccountBalance(-withdrawal, account.getAccountid());
				tdi.createNewTransaction("Withdrawal", withdrawal, account.getAccountid());
				account.setBalance(account.getBalance() - withdrawal);
				System.out.println("Successful Withdrawl: $" + withdrawal);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Withdrawal amount exceeds account balance.");
		}
		
	}
	
	public boolean close(Account account) {// Delete this account from the records
		if (account.getBalance() == 0.0) {
			try {
				adi.deleteAccountByAccountID(account.getAccountid());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Account closed successfully.");
			return true;
		} else {
			System.out.println("Accounts with a non-zero balance cannot be closed.");
			return false;
		}
	}
	
	public void createAccount() {
		try {
			adi.createNewAccount(customer.getCustomerid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Successful Account Creation.");
	}
	
	/*
	 * Customer Menus
	 */
	
	public void mainMenu() {
		display.mainMenu();
		
		int option = 0;
		while(true) { // Only accept valid int inputs (values within range)
			option = input.nextInt();
			
			if(option >= 1 && option <= 3) {
				break;
			}
			System.out.println("Not a valid option, please try again.");
		}
		
		switch (option) {
		case 1:
			login();
			break;
		case 2:
			register();
			break;
		case 3:
			input.close();
			System.exit(0);
			break;
		default:
			System.out.println("ERROR: INVALID INPUT");
			break;
		}
	}
	
	public void customerMenu() {
		while(true) {
			display.customerMenu();
			
			int option = 0;
			while(true) { // Only accept valid int inputs (values within range)
				option = input.nextInt();
				
				if(option >= 1 && option <= 3) {
					break;
				}
				System.out.println("Not a valid option, please try again.");
			}
			
			switch (option) {
			case 1:
				selectAccount();
				break;
			case 2:
				createAccount();
				break;
			case 3:
				return;
			default:
				System.out.println("ERROR: INVALID INPUT");
				break;
			}
		}
	}
	
	public void customerMenu(Customer c) {//This is how admins update customers
		customer = c;
		while(true) {
			display.manageCustomerMenu(customer.getFirstname() + " " + customer.getLastname());
			
			int option = 0;
			while(true) { // Only accept valid int inputs (values within range)
				option = input.nextInt();
				
				if(option >= 1 && option <= 4) {
					break;
				}
				System.out.println("Not a valid option, please try again.");
			}
			
			switch (option) {
			case 1:
				selectAccount();
				break;
			case 2:
				createAccount();
				break;
			case 3:
				try {
					cdi.deleteCustomerByCustomerID(customer.getCustomerid());
					customer = null;
					System.out.println("Customer Deleted Successfully.");
					return;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			case 4:
				return;
			default:
				System.out.println("ERROR: INVALID INPUT");
				break;
			}
		}
	}
	
	public void manageAccount(Account account) {
		while(true) {
			System.out.println();
			System.out.println("Account #" + account.getAccountid());
			System.out.println("===========");
			System.out.println("Balance: $" + account.getBalance());
			
			display.accountMenu();
			
			int option = 0;
			while(true) { // Only accept valid int inputs (values within range)
				option = input.nextInt();
				
				if(option >= 1 && option <= 5) {
					break;
				}
				System.out.println("Not a valid option, please try again.");
			}
			
			switch(option) {
			case 1:
				viewHistory(account);
				break;
			case 2:
				deposit(account);
				break;
			case 3:
				withdraw(account);
				break;
			case 4:
				if(close(account)) {
					return;
				}
			case 5:
				return;
			default:
				System.out.println("ERROR: INVALID INPUT");
				break;
			}
		}
	}
	
	/*
	 * Admin Functionality
	 */
	public void selectCustomer() {
		List<Customer> customers = null;
		try {
			customers = cdi.getAllCustomers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		display.customerList();
		
		for(Customer c : customers) {
			System.out.println(c.getCustomerid() + " " + c.getFirstname() + " " + c.getLastname());
		}
		
		while (true) {
			System.out.print("Choose a customer: ");
			int choice = input.nextInt();
			
			for (Customer c : customers) {
				if (c.getCustomerid() == choice) {
					customerMenu(c);
					return;
				}
			}
			
			System.out.println("Invalid choice. Try again? (Y/N)");
			String option = input.next();
			if (!option.equals("Y")) {
				return;
			}
		}
	}

	public void createCustomer() {
		display.createCustomer();
		System.out.print("Enter First Name: ");
		String firstName = input.next();
		System.out.print("Enter Last Name: ");
		String lastName = input.next();
		
		try {
			cdi.createNewCustomer(firstName, lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Successful Customer Creation.");
	}
	
	/*
	 * Admin Menus
	 */
	
	public void adminMenu() {
		while(true) {
			display.adminMenu();
			
			int option = 0;
			while(true) { // Only accept valid int inputs (values within range)
				option = input.nextInt();
				
				if(option >= 1 && option <= 3) {
					break;
				}
				System.out.println("Not a valid option, please try again.");
			}
			
			switch (option) {
			case 1:
				selectCustomer();
				break;
			case 2:
				createCustomer();
				break;
			case 3:
				return;
			default:
				System.out.println("ERROR: INVALID INPUT");
				break;
			}
			
		}
	}
	
	/*
	 *  Run & Main
	 */
	public void run() {
		while(true) {
			mainMenu();
		}
	}
	
	public static void main(String[] args) {
		Driver d = new Driver();
		d.run();
	}
}
