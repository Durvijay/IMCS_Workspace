package trng.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

import trng.io.CSVFileReader;
import trng.io.Employee;

public class BatchProgramming {
	private static final int BATCH_SIZE = 3;

	public static void main(String[] args) throws Exception {
		BatchProgramming batchProgramming = new BatchProgramming();
		batchProgramming.loadEmployeesToDB();
	}
	
	void loadEmployeesToDB() throws Exception {
		CSVFileReader csvFileReader = new CSVFileReader();
		Employee[] employees = csvFileReader.readEmployees(new File("C:/temp/EmpData.csv"));
		
		// Create SQL statement
		String SQL = "INSERT INTO Employee (Empno, EmpName, Salary) " +
		             "VALUES(?, ?, ?)";

		//Get JDBC connection
		Connection connection = JdbcConnectionFactory.getConnection();
		
		// Create PrepareStatement object
		PreparedStatement pstmt = connection.prepareStatement(SQL);

		try {
			//Set auto-commit to false
			connection.setAutoCommit(false);
			int count = 1;
			boolean hasLeftOverBatchRecords = true;
			for (Employee employee : employees) {
				
				if (employee == null) break;
				
				// Set the variables
				pstmt.setInt( 1, Integer.parseInt(employee.getEmpID()));
				pstmt.setString( 2, employee.geteName());
				pstmt.setFloat(3, employee.getBasicSalary());
				
				// Add it to the batch
				pstmt.addBatch();

				if (count++ % BATCH_SIZE == 0) {
					//Create an int[] to hold returned values
					int[] updateCount = pstmt.executeBatch();
					hasLeftOverBatchRecords = false;
				} else {
					hasLeftOverBatchRecords = true;
				}
			}
			
			if(hasLeftOverBatchRecords) {
				int[] updateCount = pstmt.executeBatch();
			}
			
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//Explicitly commit statements to apply changes			
			connection.rollback();
		}
	}
}
