package trng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public abstract class AbstractDAOImpl {
	Connection con;
	Statement statement;

	public AbstractDAOImpl() {

		try {
			con = JdbcConnectionFactory.getConnection();

			statement = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
