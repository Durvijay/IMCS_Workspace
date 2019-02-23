package trng.jtrng4u.rest;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PersonRestClient {

	static String URL = "http://localhost:8080/MySpringRest/persons";
	
	public static void main(String[] args) {

//		deletePerson();
		
		Person person = createPerson();

		getPerson(person.getPid());
		
		updatePeson(person.getPid());
		
		deletePerson(person.getPid());
	}

	
	private static void deletePerson(int personId) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URL + "/" + personId);
	}


	private static void updatePeson(int personId) {
		RestTemplate restTemplate = new RestTemplate();
		Person newPerson = new Person(personId, "david2334", "test3434343", 30, "M","DFW");
		HttpEntity<Person> entity = new HttpEntity<Person>(newPerson);
//		restTemplate.postForObject(url, newPerson, String.class);
		ResponseEntity<Person> responseEntity = restTemplate.exchange(URL, HttpMethod.PUT, entity, Person.class);
		if (responseEntity.getStatusCode() == HttpStatus.ACCEPTED) {
			System.out.println("Person data created successfully");
		} else {
			System.out.println("Person data creation failed");
		}
	}


	private static void getPerson(int personId) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//		Person person = restTemplate.getForObject(url, Person.class);
		ResponseEntity<Person> responseEntity = restTemplate.exchange(URL + "/" + personId, HttpMethod.GET, entity, Person.class);
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getBody());

	}
	
	private static Person createPerson() {
		RestTemplate restTemplate = new RestTemplate();
		Person newPerson = new Person(null, "david2334", "test3434343", 30, "M","Addison");
		HttpEntity<Person> entity = new HttpEntity<Person>(newPerson);
//		restTemplate.postForObject("http://localhost:8080/MySpringRest/person", newPerson, String.class);
		ResponseEntity<Person> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, entity, Person.class);
		if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
			System.out.println("Person data created successfully, id: " + responseEntity.getBody().getPid());
			return responseEntity.getBody();
		} else {
			System.out.println("Person data creation failed");
			System.exit(1);
			return null;
		}
	}
}
