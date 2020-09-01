package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Login;

public interface LoginDao {
	//CRUD ops
	public void createNewLogin(String username, String password) throws SQLException;
	public List<Login> getAllLogins() throws SQLException;
	public List<Login> getAllLoginsByCustomerID(int id) throws SQLException;
	public void updateLoginCustomerID(String username, int id) throws SQLException;
	public Login getLoginByUsername(String username) throws SQLException;
}
