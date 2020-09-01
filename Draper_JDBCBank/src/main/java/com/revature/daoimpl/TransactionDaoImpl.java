package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Transaction;
import com.revature.dao.TransactionDao;
import com.revature.util.ConnFactory;

public class TransactionDaoImpl implements TransactionDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createNewTransaction(String type, float amount, int accountid) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into transactions (transactiontype, amount, accountid) values (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, type);
		ps.setFloat(2, amount);
		ps.setInt(3, accountid);
		ps.executeUpdate();
	}
	
	public List<Transaction> getAllTransactions() throws SQLException {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from transactions");
		Transaction t = null;
		while(rs.next()) {
			t = new Transaction(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
			transactionList.add(t);
		}
		return transactionList;
	}

	public List<Transaction> getAllTransactionByAccountID(int id) throws SQLException {
		List<Transaction> transactionList = new ArrayList<Transaction>();
		Connection conn = cf.getConnection();
		String sql = "select * from transactions where accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Transaction t = null;
		while(rs.next()) {
			t = new Transaction(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
			transactionList.add(t);
		}
		return transactionList;
	}

	public Transaction getTransactionByTransactionID(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from transactions where transactionid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Transaction t = null;
		while(rs.next()) {
			t = new Transaction(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
		}
		return t;
	}
	
	public static void main(String[] args) throws SQLException {
		TransactionDaoImpl tdi = new TransactionDaoImpl();
		tdi.createNewTransaction("Deposit", 200.37f, 1);
	}
}
