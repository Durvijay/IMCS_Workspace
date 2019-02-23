package trng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeptEmployeeTest {

	Connection con;
	PreparedStatement pStatement;
	
	DeptEmployeeTest () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "uroot");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DeptEmployeeTest deTest = new DeptEmployeeTest();
		deTest.insertEmp();
	}
	
	void insertEmp() {
		System.out.println("Inserting Record...");
		try {
//			PreparedStatement pStatement = con.prepareStatement("INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (8001, 'Manohar', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 10)");
			
			PreparedStatement pStatement = con.prepareStatement("INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			pStatement.setInt(1, 8001);
			pStatement.setString(2, "Manohar");
			pStatement.setString(3, "SALESMAN");
			pStatement.setInt(4, 7698);
			pStatement.setString(5, "1981-09-08");
			pStatement.setInt(6, 1500);
			pStatement.setInt(7, 0);
			pStatement.setInt(8, 10);
			
			pStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
