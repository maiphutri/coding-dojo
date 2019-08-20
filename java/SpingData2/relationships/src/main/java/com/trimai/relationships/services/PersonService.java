package com.trimai.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.relationships.models.Person;
import com.trimai.relationships.repositories.PersonRepo;

@Service
public class PersonService {
	@Autowired
	private PersonRepo personRepo;
	
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	
	public Person getPerson(Long id) {
		Optional<Person> person = personRepo.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}
	
	public List<Person> allPerson() {
		return personRepo.findAll();
	}
}
