package trng.imcs.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import trng.imcs.dao.PersonRepository;
import trng.imcs.entity.Person;
@Service
public class PersonService implements IPersonService {
	@Autowired
	private PersonRepository personDAO;
	@Override
	public Person getPersonById(int pid) {
		Person obj = personDAO.findOne(pid);
		return obj;
	}	
	@Override
	public List<Person> getAllPersons(){
		return Lists.newArrayList(personDAO.findAll());
	}
	
	@Override
	public synchronized boolean addPerson(Person person){
       if (personDAO.exists(person.getPid())) {
    	   return false;
       } else {
    	   personDAO.save(person);
    	   return true;
       }
	}
	@Override
	public void updatePerson(Person person) {
		personDAO.save(person);
	}
	@Override
	public void deletePerson(int pid) {
		personDAO.delete(pid);
	}
}
