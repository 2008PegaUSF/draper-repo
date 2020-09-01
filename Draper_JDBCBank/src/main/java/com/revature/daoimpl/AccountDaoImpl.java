package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDao;
import com.revature.util.ConnFactory;

public class AccountDaoImpl implements AccountDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createNewAccount(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into accounts (balance, customerid) values (0, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public List<Account> getAllAccounts() throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from accounts");
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getFloat(2),rs.getInt(3));
			accountList.add(a);
		}
		return accountList;
	}

	public List<Account> getAllAccountsByCustomerID(int id) throws SQLException {
		List<Account> accountList = new ArrayList<Account>();
		Connection conn = cf.getConnection();
		String sql = "select * from accounts where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getFloat(2),rs.getInt(3));
			accountList.add(a);
		}
		return accountList;
	}

	public Account getAccountByAccountID(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from accounts where accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getInt(1), rs.getFloat(2), rs.getInt(3));
		}
		return a;
	}
	
	public void setAccountBalance(float amount, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update accounts set balance = ? where accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setFloat(1, amount);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void updateAccountBalance(float amount, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update accounts set balance = balance + ? where accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setFloat(1, amount);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void deleteAccountByAccountID(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from accounts where accountid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public static void main(String[] args) throws SQLException {
		AccountDaoImpl adi = new AccountDaoImpl();
		adi.updateAccountBalance(-200, 1);
	}
}
