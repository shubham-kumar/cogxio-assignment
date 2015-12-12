package com.cogxio.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static Connection con;

	public Connection setConnection() throws SQLException,ClassNotFoundException {
		String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName);
		String url = "jdbc:mysql://localhost:3306/cogxio";
		String uid = "root";
		String pwd = "root";
		con = DriverManager.getConnection(url, uid, pwd);
		
		return con;
	}

	public void closeConnection() throws SQLException {
			con.close();
	}


}
