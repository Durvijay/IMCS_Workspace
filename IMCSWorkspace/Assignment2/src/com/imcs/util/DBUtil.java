package com.imcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
	public static Connection dbcon;
	private Statement dbStmt;
	private ResultSet dbRst;

	public static Connection setDBConnection() {

		if (dbcon != null)
			return dbcon;

		try {
			ResourceBundle bundle = ResourceBundle.getBundle("com.imcs.resources.database");
			Class.forName(bundle.getString("driver"));
			dbcon = DriverManager.getConnection(bundle.getString("url"), bundle.getString("username"),
					bundle.getString("password"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return dbcon;
	}

	public ResultSet getResultSet(String sqlQuery, Connection conn) throws SQLException {

		System.out.println(sqlQuery);
		dbcon = conn;
		try {
			dbStmt = dbcon.createStatement();
			dbRst = dbStmt.executeQuery(sqlQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbRst;
	}

	public static void closeConnection(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBUtil.setDBConnection();
	}

}
