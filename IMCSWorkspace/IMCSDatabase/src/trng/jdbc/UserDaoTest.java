package trng.jdbc;

public class UserDaoTest {

	public static void main(String[] args) throws Exception
	{
		UserDao dao = new UserDaoImpl();
		
		User user = new User();
		user.setId(105);
		user.setUserName("New Ravi");
		user.setDepartment("New Dept");

		dao.update(user);
		
		User updatedUser = dao.loadUser("101");
		System.out.printf("%s %s %s", updatedUser.getId(),
				updatedUser.getUserName(), updatedUser.getDepartment());
	}

}
