package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDao {
	//CRUD ops
	public void createNewAccount(int id) throws SQLException;
	public List<Account> getAllAccounts() throws SQLException;
	public List<Account> getAllAccountsByCustomerID(int id) throws SQLException;
	public void setAccountBalance(float amount, int id) throws SQLException;
	public void updateAccountBalance(float amount, int id) throws SQLException;
	public Account getAccountByAccountID(int id) throws SQLException;
	public void deleteAccountByAccountID(int id) throws SQLException;
}
