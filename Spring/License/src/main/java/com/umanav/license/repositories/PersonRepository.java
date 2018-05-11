package com.umanav.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umanav.license.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
	List<Person> findAllByLicenseNull();
}
