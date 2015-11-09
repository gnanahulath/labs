package com.gk.ginger.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gk.ginger.model.Person;

//@Repository Removed Here
public interface PersonRepository extends MongoRepository<Person, Long> {

	List<Person> findByName(String name);

}