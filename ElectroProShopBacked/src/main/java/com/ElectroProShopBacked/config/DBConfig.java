package com.ElectroProShopBacked.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
private static DBConfig dBConfig=new DBConfig();
private Connection con;
private String url = "jdbc:mysql://localhost:3306/electroshop";
private String user = "root";
private String pass = "himanshu";
private String driverClass = "com.mysql.jdbc.Driver";

private DBConfig(){
	try {
		Class.forName(driverClass);
		con = DriverManager.getConnection(url, user, pass);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public Connection getConnection(){
	return con;
}
public static DBConfig getDBConfig(){
	return dBConfig;
}
@Override
	protected void finalize() throws Throwable {
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	super.finalize();
	}
}