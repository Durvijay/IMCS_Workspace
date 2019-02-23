package trng.imcs.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import trng.imcs.entity.Person;


public interface PersonRepository extends CrudRepository<Person, Integer> {
	Person findByUsername(String username);
	Person findByUsernameAndPassword(String username, String password);
	Person findByUsernameOrPassword(String username, String password);
	@Query("select p from Person as p where userName = :username and password= :password")
	List<Person> findData(String username, String password);

}

 