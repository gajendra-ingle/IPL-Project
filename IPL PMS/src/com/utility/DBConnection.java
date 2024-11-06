package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DBNAME = "ipl";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getMySqlConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL + DBNAME, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

}
