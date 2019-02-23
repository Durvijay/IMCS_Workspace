package trng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * This class does the the following:
 *  a. Register the driver.
 *  b. Create connection
 *  c. Create statement.
 *  d. Create ResultSet object.
 *  
 * @author Manohar
 *
 */
public class JDBCConnectionTest {


	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs3","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user");
			
			while (rs.next()) {
				System.out.printf( "%-15s %15s %n", rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
