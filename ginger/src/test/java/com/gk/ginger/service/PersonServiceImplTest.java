package com.gk.ginger.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gk.ginger.Application;
import com.gk.ginger.model.Person;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonServiceImplTest {
	
	@Autowired
	private PersonService personService;

	@Test
	public void testCreatePerson() {
		Person createPerson = personService.createPerson(new Person(1L,"Gnanahulath"));
		assertEquals("Gnanahulath", createPerson.getName());
	}
}
