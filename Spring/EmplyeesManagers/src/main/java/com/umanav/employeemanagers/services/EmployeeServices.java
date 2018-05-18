package com.umanav.employeemanagers.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.employeemanagers.models.Employee;
import com.umanav.employeemanagers.repositories.Repo;


@Service
public class EmployeeServices {
    private final Repo repo;
    public EmployeeServices(Repo repo) {
        this.repo=repo;
    }
    public void addEmployee(Employee employee) {
    	repo.save(employee);
	}
	
	public Employee findByName(String firstName,
			String lastName) {
		return repo.findByName(firstName, lastName);
	}

	public Employee findById(Long id) {
		Optional<Employee> employee = repo.findById(id);
		return employee.get();
	}
}

