package com.gk.ginger.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.ginger.model.Person;
import com.gk.ginger.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Collection<Person> getPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

	@Override
	public Person getPerson(long id) {
		return personRepository.findOne(id);
	}

}
