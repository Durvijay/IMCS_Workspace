package trng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyFirstJDBCProg {
	Connection con;
	
	MyFirstJDBCProg () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		MyFirstJDBCProg jdbcProg = new MyFirstJDBCProg();
		
		
//		jdbcProg.insertRecords();
//		jdbcProg.displayRecrods();
		
		System.out.println("Inserting...");
		jdbcProg.updateRecord();
		jdbcProg.displayRecrods();
		
		jdbcProg.deleteRecords();
		jdbcProg.displayRecrods();
	}
	
	
	private void deleteRecords() throws SQLException {
		System.out.println("Deleting Records...");
		ResultSet rs =	null;

		try {
			
			String insertQuery = "delete from user where id = 105";
			Statement statement = con.createStatement();
			int deleteCount = statement.executeUpdate(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}

		
			
	}

	private void updateRecord() throws SQLException {
		System.out.println("Updatng Records...");
		ResultSet rs =	null;

		try {
			String updateQuery = "update user set username = 'Petor' where id = 105";
			Statement statement = con.createStatement();
			int updateCount = statement.executeUpdate(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}

		
			
			
	}

	private void insertRecords() throws SQLException {
		System.out.println("Inserting Record...");
		
		ResultSet rs =	null;

		try {
			String insertQuery = "insert into user (id, username, department) values ('105', 'David', '60')";
			Statement statement = con.createStatement();
			int updateCount = statement.executeUpdate(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}

		
	}

	void displayRecrods() throws SQLException {
		System.out.println("Displaying Records...");
		ResultSet rs =	null;
		
		try {
			Statement statement = con.createStatement();
			rs = statement.executeQuery("select * from user");
			
			while(rs.next()) {
				System.out.printf("%6s %6s %6s\n", rs.getString("id"), rs.getString("username"), rs.getString("department"));
			}
			
			System.gc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.printf("Inside finalyze");
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.finalize();
	}
}
	
