package com.ElectroProShopBacked.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ElectroProShopBacked.config.DBConfig;
import com.ElectroProShopBacked.model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	private Connection con;
	private PreparedStatement ps;

	public UserDetailsDAOImpl() {
		con = DBConfig.getDBConfig().getConnection();
	}

	public boolean addUserDetails(UserDetails userDetails) {
		String query = "insert into UserDetails(full_name,email,mobile,address,username,password) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, userDetails.getFull_name());
			ps.setString(2, userDetails.getEmail());
			ps.setLong(3, userDetails.getMobile());
			ps.setString(4, userDetails.getAddress());
			ps.setString(5, userDetails.getUsername());
			ps.setString(6, userDetails.getPassword());
			int x = ps.executeUpdate();
			return x > 0;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean validateUser(String username, String password) {
		String query = "select username,password from UserDetails where username=? and password=?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
				if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password")))
					return true;
		} catch (SQLException e) {
			return false;
		}
		return false;
	}

}
