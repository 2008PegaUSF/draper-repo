package com.revature.tests;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Login;
import com.revature.beans.Transaction;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.daoimpl.LoginDaoImpl;
import com.revature.daoimpl.TransactionDaoImpl;

public class TestDriver {

	@Test
	public void CustomerTest() {
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		Customer c = null;
		try {
			c = cdi.getCustomerByCustomerID(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String actual = c.toString();
		String expected = "Customer [customerid=1, firstname=Jack, lastname=Whaley]";
		
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	public void AccountTest() {
		AccountDaoImpl adi = new AccountDaoImpl();
		Account a = null;
		try {
			a = adi.getAccountByAccountID(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String actual = a.toString();
		String expected = "Account [accountid=1, balance=" + a.getBalance() + ", customerid=1]";
		
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	public void TransactionTest() {
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		Transaction t = null;
		try {
			t = tdi.getTransactionByTransactionID(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String actual = t.toString();
		String expected = "Transaction [transactionid=1, type=Deposit, amount=100.0, accountid=1]";
		
		Assertions.assertEquals(expected,actual);
	}
	
	@Test
	public void LoginTest() {
		LoginDaoImpl ldi = new LoginDaoImpl();
		Login l = null;
		try {
			l = ldi.getLoginByUsername("jwhaley");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String actual = l.toString();
		String expected = "Login [username=jwhaley, password=pass1, type=Customer, customerid=1]";
		
		Assertions.assertEquals(expected,actual);
	}
}
