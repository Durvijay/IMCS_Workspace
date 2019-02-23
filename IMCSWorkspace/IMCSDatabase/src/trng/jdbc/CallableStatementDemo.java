package trng.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo {
	public static void main(String[] args) throws SQLException {
		CallableStatementDemo callableStatementDemo = new CallableStatementDemo();

//		callableStatementDemo.executeProcedure();
		callableStatementDemo.executeFunction();
	}
	
	private void executeFunction() {
		Connection con = JdbcConnectionFactory.getConnection();
		try {
			
			//Prepare CallableStatement with the required procedure/function 
			CallableStatement callableStatement = con.prepareCall("{? = CALL get_customer_balance(?, ?)}");
			
			//Set the values for function.
			callableStatement.setInt(2,  259);
			callableStatement.setDate(3,  new java.sql.Date(2015, 12, 12));
			
			//Register for any output parameters
			callableStatement.registerOutParameter(1, java.sql.Types.DOUBLE);
			
			//Execute the callableStatement 
			callableStatement.execute();
			
			//Retrieve the result. 
			System.out.println("customer_balance is :" + callableStatement.getDouble(1));				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void executeProcedure() {
		Connection con = JdbcConnectionFactory.getConnection();
		try {
			
			//Prepare CallableStatement with the required procedure/function 
			CallableStatement callableStatement = con.prepareCall("CALL film_in_stock(?, ?, ?)");
			
			//Set the values for function.
			callableStatement.setInt(1,  1);
			callableStatement.setInt(2,  1);
			
			//Register for any output parameters
			callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			
			//Execute the callableStatement 
			callableStatement.execute();
			
			//Fetch the result set 
			ResultSet rs = callableStatement.getResultSet();
			
			//Iterate through to retrieve values.
			while(rs.next()) {
				System.out.println(rs.getInt(1));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
