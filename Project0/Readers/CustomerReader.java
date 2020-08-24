package Readers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import DataObjects.Account;
import Users.Customer;

public class CustomerReader {

	// Members
	File filePath;
	ArrayList<Customer> cList;
	
	// No Arg Constructor
	public CustomerReader() {
		this("src/customers/CustomerList.txt");
	}
	
	// Arg Constructor
	public CustomerReader(String s) {
		filePath = new File(s);
		cList = new ArrayList<Customer>();
		load();
	}
	
	// Read accounts from the file
	public void load() {
		try {
			Scanner fileReader = new Scanner(filePath);
				
			while (fileReader.hasNext()) {
				String s = fileReader.nextLine();
				
				cList.add(Customer.readFromLine(s));
			}
				
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Post account list to file
	public void post() {
		try {
			FileWriter fw = new FileWriter(filePath);
			
			for(Customer c : cList) {
				fw.write(c.readToLine() + '\n');
				c.post();
			}
			
			fw.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Add a customer
	public void add(Customer e) {
		cList.add(e);
	}
	
	// Get an account from an ID
	public Customer getByID(int id) {
		for(Customer c : cList) {
			if (c.getID() == id) {
				return c;
			}
		}
		
		System.out.println("No Account with ID " + id + " found.");
		return null;
	}
	
	public static void main(String[] args) {
		CustomerReader cr = new CustomerReader();
		Customer c = cr.getByID(1000);
		Account a = c.getAccount(1111);
		c.deposit(a,13345);
		
		c.post();
	}
}
