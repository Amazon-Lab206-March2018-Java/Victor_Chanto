package com.umanav.employeemanagers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.umanav.employeemanagers.models.Employee;

public interface Repo extends CrudRepository<Employee, Long> {

	List<Employee> findAll();
	
	@Query("SELECT e from Employee e WHERE firstName = ?1 AND lastName = ?2")
	Employee findByName(String firstName, String lastName);
}
