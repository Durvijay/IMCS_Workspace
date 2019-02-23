package trng.imcs.service;

import java.util.List;

import trng.imcs.entity.Person;

public interface IPersonService {
     List<Person> getAllPersons();
     Person getPersonById(int pid);
     boolean addPerson(Person person);
     void updatePerson(Person person);
     void deletePerson(int pid);
}
