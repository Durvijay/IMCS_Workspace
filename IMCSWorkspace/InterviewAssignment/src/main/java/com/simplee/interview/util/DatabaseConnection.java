package com.simplee.interview.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	private Connection conn = null;
	private static DatabaseConnection dbCon = null;
	String DB_NAME;
	private DatabaseConnection() {
		
	}
	
	public static Connection getConnection(){
		if(dbCon!=null)
			return dbCon.conn;
		dbCon = new DatabaseConnection();
		Properties dbProp = new Properties();
		try {
			dbProp.load(DatabaseConnection.class.getClassLoader()
					.getResourceAsStream(
							"com/simplee/interview/util/connection.properties"));
		
			System.out.println("IN DB .....");
			String DB_DRIVER = dbProp.getProperty("DB_DRIVER");
			String DB_URL = dbProp.getProperty("DB_URL");
			dbCon.DB_NAME = dbProp.getProperty("DB_NAME");
			String DB_USER = dbProp.getProperty("DB_USER");
			String DB_PASSWORD = dbProp.getProperty("DB_PASSWORD");

	
			//Class.forName(dbConfig.getDbDriver());// 
			Class.forName(DB_DRIVER);
			
			dbCon.conn = DriverManager.getConnection(DB_URL + dbCon.DB_NAME, DB_USER,
					DB_PASSWORD);
			
			/*dbCon = DriverManager.getConnection(dbConfig.getDbUrl()+dbConfig.getDbName(),
					dbConfig.getDbUser(),
					dbConfig.getDbPassword());*/
		} catch (ClassNotFoundException e) {
			System.out.println("Error : Class Not Found " + e);
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("Error : SQL Error " + e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dbCon.conn;

	}
	
	@Override
	protected void finalize() throws Throwable {
		dbCon.conn.close();
	}

	public static String getDB_NAME() {
		return dbCon.DB_NAME;
	}
}
