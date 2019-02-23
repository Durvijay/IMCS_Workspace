package trng.imcs.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import trng.imcs.entity.Person;
import trng.imcs.service.IPersonService;
@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private IPersonService personService;

	@RequestMapping(value={"/", ""}, method = RequestMethod.GET)
	public ResponseEntity<?> getPersons() {
  		return new ResponseEntity(personService.getAllPersons(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addPerson(@RequestBody Person person) {
    	boolean flag = personService.addPerson(person);
    	if (flag)
    		return new ResponseEntity(HttpStatus.CREATED);
    	else 
    		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	@RequestMapping(value="/{personById}", method = RequestMethod.GET, consumes={"application/json"}, produces={"application/json"})
	public Person getPersonById(@PathVariable("personById") String pid) {
		return personService.getPersonById(Integer.parseInt(pid));
	}
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updatePerson(@RequestBody Person person) {
			personService.updatePerson(person);
			return new ResponseEntity(HttpStatus.ACCEPTED);
	}	
	@RequestMapping(value="/{personById}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@PathVariable("personById") String pid) {
		personService.deletePerson(Integer.parseInt(pid));
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
}	