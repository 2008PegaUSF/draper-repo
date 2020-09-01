package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Transaction;

public interface TransactionDao {
	//CRUD ops
	public void createNewTransaction(String type, float amount, int accountid) throws SQLException;
	public List<Transaction> getAllTransactions() throws SQLException;
	public List<Transaction> getAllTransactionByAccountID(int id) throws SQLException;
	public Transaction getTransactionByTransactionID(int id) throws SQLException;
}
