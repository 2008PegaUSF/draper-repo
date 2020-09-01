package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {
	//CRUD ops
	public void createNewCustomer(String firstName, String lastName) throws SQLException;
	public List<Customer> getAllCustomers() throws SQLException;
	public Customer getCustomerByCustomerID(int id) throws SQLException;
	public Customer getLastCustomer() throws SQLException;
	public void updateCustomerFirstName(String firstName, int id) throws SQLException;
	public void updateCustomerLastName(String lastName, int id) throws SQLException;
	public void deleteAllCustomers() throws SQLException;
	public void deleteCustomerByCustomerID(int id) throws SQLException;
}
