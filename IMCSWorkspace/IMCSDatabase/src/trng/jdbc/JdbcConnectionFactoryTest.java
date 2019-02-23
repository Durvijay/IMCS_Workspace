package trng.jdbc;

import java.sql.Connection;

public class JdbcConnectionFactoryTest {

	public static void main(String[] args) {
		JdbcConnectionFactory jdbcConnectionFactory = JdbcConnectionFactory.createInstance();
//		Connection connection = jdbcConnectionFactory.getConnection();
		
//		System.out.println(jdbcConnectionFactory);
//		System.out.println(connection);
//		
		JdbcConnectionFactory jdbcConnectionFactory1 = JdbcConnectionFactory.createInstance();
		Connection connection1 = jdbcConnectionFactory.getDSConnection();

		System.out.println(jdbcConnectionFactory1);
		System.out.println(connection1);
	}
}
