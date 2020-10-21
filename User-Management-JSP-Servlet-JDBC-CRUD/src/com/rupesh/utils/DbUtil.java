package com.rupesh.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private static Connection connection;

	static {
		try {
			if (connection == null) {
				Class.forName(DRIVER_CLASS_NAME);
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		} catch (Exception e) {
			System.out.println("Connection Error :" + e);
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
