package trng.jdbc;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {
	List<User> loadUsers();
		
	User loadUser(String id) throws SQLException;
	
	boolean addUser(User user);

	boolean update(User user);
	
	boolean updateUsername(int id, String name);
	
	boolean deleteUser(String  id);
}
	
