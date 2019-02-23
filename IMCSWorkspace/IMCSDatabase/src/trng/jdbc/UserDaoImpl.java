package trng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl extends AbstractDAOImpl implements UserDao {

	
	UserDaoImpl () {
	}

	@Override
	public List<User> loadUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loadUser(String id) throws SQLException {
		System.out.println("Displaying Records...");
		User user = null;
		ResultSet rs = null;
		try {
			rs =	statement.executeQuery("select * from user where id = " + id);
			
			user = new User();
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setDepartment(rs.getString(3));
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
		
		return user;
	}

	@Override
	public boolean update(User user) {
		System.out.println("Updatng Records...");
		boolean flag = false;
		try {
			StringBuilder insertQuery = new StringBuilder();
			
			insertQuery.append("update user set username = '")
					.append(user.getUserName()).append("'")
					.append(", department = '").append(user.getDepartment())
					.append("'").append(" where id = ").append(user.getId());
					
			flag = statement.execute(insertQuery.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return flag;
	}

	@Override
	public boolean deleteUser(String id) {
		return true;
	}

	@Override
	public boolean updateUsername(int id, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
