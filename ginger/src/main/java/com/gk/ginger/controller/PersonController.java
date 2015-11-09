package com.gk.ginger.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gk.ginger.model.Person;
import com.gk.ginger.service.PersonService;

@RestController
public class PersonController extends AbstractController{

	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping(value = "api/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Person>> getPersons() {
		// Collection<Person> persons = personService.getPersons();
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1L, "Gnanahulath"));
		return new ResponseEntity<Collection<Person>>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "api/persons/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
		Person person = personService.getPerson(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "api/persons", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person newPerson = personService.createPerson(person);
		return new ResponseEntity<Person>(newPerson, HttpStatus.OK);
	}
}
