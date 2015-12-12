package com.cogxio.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static Connection con;

	public Connection setConnection() throws SQLException,ClassNotFoundException {
		String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName);
		String url = "postgres://ubpqgjceupxruk:KUKMchSS6x_eWD5b-5W6myxy8S@ec2-54-83-59-203.compute-1.amazonaws.com:5432/dfhpss5k8cqkb5";
		String uid = "ubpqgjceupxruk";
		String pwd = " KUKMchSS6x_eWD5b-5W6myxy8S";

		con = DriverManager.getConnection(url, uid, pwd);
		
		return con;
	}

	public void closeConnection() throws SQLException {
			con.close();
	}


}
