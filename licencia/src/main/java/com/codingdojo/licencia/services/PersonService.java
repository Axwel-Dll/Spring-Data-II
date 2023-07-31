package com.codingdojo.licencia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.licencia.models.Person;
import com.codingdojo.licencia.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person create(Person person) {
		return personRepository.save(person);
	}

	public Person getPerson(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}

	public List<Person> obtenerPersonasSinLicencia() {
		return personRepository.findByLicenseIsNull();
	}
	
}
