package com.gk.ginger.service;

import java.util.Collection;

import com.gk.ginger.model.Person;

public interface PersonService {
	
	Collection<Person> getPersons();

	Person createPerson(Person person);

	Person getPerson(long id);
}
