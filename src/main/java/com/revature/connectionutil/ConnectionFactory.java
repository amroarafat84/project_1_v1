package com.revature.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cf = null;

	private ConnectionFactory() {
	}

	public static synchronized ConnectionFactory getInstance() {
		if (cf == null)
			cf = new ConnectionFactory();
		return cf;
	}

	public Connection getConnection() {
		Properties prop = new Properties();
		
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/mydbinstancedb?useTimezone=true&serverTimezone=GMT";
		String username = "amro";
		String password = "Buick1973";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
