package com.umanav.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.license.models.Person;
import com.umanav.license.repositories.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	public List<Person> getPeople(){
		return personRepository.findAll();
	}
	public List<Person> noLicense(){
		return personRepository.findAllByLicenseNull();
	}
	public Person byID(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}

}
