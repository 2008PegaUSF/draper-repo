package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Login;
import com.revature.dao.LoginDao;
import com.revature.util.ConnFactory;

public class LoginDaoImpl implements LoginDao {

	ConnFactory cf = ConnFactory.getInstance();
	
	public void createNewLogin(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into logins (username, password, usertype) values (?, ?, 'Customer')";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ps.executeUpdate();
	}
	
	public List<Login> getAllLogins() throws SQLException {
		List<Login> loginList = new ArrayList<Login>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from logins");
		Login l = null;
		while(rs.next()) {
			l = new Login(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			loginList.add(l);
		}
		return loginList;
	}

	public List<Login> getAllLoginsByCustomerID(int id) throws SQLException {
		List<Login> loginList = new ArrayList<Login>();
		Connection conn = cf.getConnection();
		String sql = "select * from logins where customerid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs =ps.executeQuery();
		Login l = null;
		while(rs.next()) {
			l = new Login(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			loginList.add(l);
		}
		return loginList;
	}

	public Login getLoginByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from logins where username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		Login l = null;
		while(rs.next()) {
			l = new Login(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		return l;
	}
	
	public void updateLoginCustomerID(String username, int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update logins set customerid = ? where username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, username);
		ps.executeUpdate();
	}
}
