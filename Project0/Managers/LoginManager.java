package Managers;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Users.Login;

public class LoginManager {
	
	// Members
	private String type;
	private File filePath;
	private ArrayList<Login> lList;
	
	public LoginManager(String type) {
		this.type = type;
		filePath = new File("src/logins/"+type+"Logins.txt");
		lList = new ArrayList<Login>();
		load();
	}
	
	// Login as an existing user
	public void login(String username, String password) {
		
		for (Login l : lList) {
			if (username.equals(l.getUsername()) && password.equals(l.getPassword())) {
				System.out.println("Successfully logged into account #" + l.getId() + "!");
				return;
			}
		}
				
		System.out.println("No login " + type + " found with given credentials.");
	}
	
	// Register as a new user
	public void register(String username, String password) {
		int highestID = 999;
		
		for (Login l : lList) {
			if (username.equals(l.getUsername())) {
				System.out.println("Username: " + username + " is already taken.");
				return;
			}
			highestID = l.getId();
		}
		int newID = highestID + 1;
		
		Login l = Login.readFromString(username + " " + password + " " + newID);
		lList.add(l);
		
		System.out.println("Account #" + newID + " created successfully!");
	}
	
	// Read in all login credentials from the file
	public void load() {
		try {
			Scanner fileReader = new Scanner(filePath);
			
			while (fileReader.hasNext()) {
				Login l = Login.readFromString(fileReader.nextLine());
				lList.add(l);
			}
			
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Read out all login credentials to the file
	public void post() {
		try {
			FileWriter fw = new FileWriter(filePath);
			
			for (Login l : lList) {
				fw.write(l.readToLine() + "\n");
			}
			
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		LoginManager lm = new LoginManager("Employee");
		
		lm.login("davemd", "aBadPassword");
		lm.login("jackbw", "aWorsePassword");
		lm.register("rachelaf", "thisPasswordIsBetterThanAllTheOthersDueToItsExcessiveLength1123");
		
		lm.post();
	}
	
}
