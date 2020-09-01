package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDao;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createNewCustomer(String firstName, String lastName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into customers (firstname, lastname) values (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.executeUpdate();
	}
	
	public List<Customer> getAllCustomers() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customers");
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
			customerList.add(c);
		}
		return customerList;
	}
	
	public Customer getCustomerByCustomerID(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from customers where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Customer c = null;
		while (rs.next()) {
			c = new Customer(rs.getInt(1), rs.getString(2),rs.getString(3));
		}
		return c;
	}
	
	public Customer getLastCustomer() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from customers");
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		return c;
	}
	
	public void updateCustomerFirstName(String firstName, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update customers set firstname = ? where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void updateCustomerLastName(String lastName, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update customers set lastname = ? where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, lastName);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void deleteAllCustomers() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from customers");
	}
	
	public void deleteCustomerByCustomerID(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from customers where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public static void main(String[] args) throws SQLException {
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		cdi.updateCustomerFirstName("Jack", 1);
		cdi.updateCustomerLastName("Whaley", 1);
	}
}
