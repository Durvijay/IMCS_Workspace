package trng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PreparedStatementTest {
	Connection con;
	
	PreparedStatementTest () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs3", "root", "root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		PreparedStatementTest jdbcProg = new PreparedStatementTest();
		
		
		jdbcProg.insertRecords();
		jdbcProg.displayRecrods();
		
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
			PreparedStatement pStatement =  con.prepareStatement("delete from user where id = ? ");
			
			pStatement.setInt(1, 105);
			pStatement.executeUpdate();
			
			pStatement.setInt(1, 106);
			pStatement.executeUpdate();

			
			//Batch operations using Prepared Satement 
//			pStatement.addBatch("delete from user where id = 105 ");
//			pStatement.addBatch("delete from user where id = 106 ");
			
//			pStatement.executeBatch();
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

		try {
			PreparedStatement pStatement =   con.prepareStatement("update user set username = ? where id = ?");
			
			pStatement.setString(1, "Raj");
			pStatement.setInt(2, 105);
			pStatement.executeUpdate();

			pStatement.setString(1, "Manoj");
			pStatement.setInt(2, 106);
			pStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	private void insertRecords() throws SQLException {
		System.out.println("Inserting Record...");
		
		ResultSet rs =	null;

		try {
			
			PreparedStatement pStatement =  con.prepareStatement("insert into user (id, username, department) values (?, ?, ?)");
			
			pStatement.setInt(1, 105);
			pStatement.setString(2, "Nave");
			pStatement.setString(3, "50");
			pStatement.executeUpdate();

			pStatement.setInt(1, 106);
			pStatement.setString(2, "Kavi");
			pStatement.setString(3, "60");
			pStatement.executeUpdate();
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
			PreparedStatement pStatement = con.prepareStatement("select * from user");
			rs =	pStatement.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%6s %6s %6s\n", rs.getString("id"), rs.getString("username"), rs.getString("department"));
			}
			
			//System.gc();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
	}

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
	
