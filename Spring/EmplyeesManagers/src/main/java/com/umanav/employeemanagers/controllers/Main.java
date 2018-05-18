package com.umanav.employeemanagers.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umanav.employeemanagers.models.Employee;
import com.umanav.employeemanagers.services.EmployeeServices;

@Controller
public class Main {
	
	private final EmployeeServices employeeService;
	public Main(EmployeeServices employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping("/")
	public String index() {
		//Creates the employees
//		Employee employee1 = new Employee("Victor","Chanto");
//		Employee employee2 = new Employee("Alex","Chavarria");
//		Employee employee3 = new Employee("Rodolfo","Avalos");
//		Employee employee4 = new Employee("Javier","Villalobos");
//		Employee employee5 = new Employee("Ana","Murillo");
		
		//adds the employees to the DataBase
//		employeeService.addEmployee(employee1);
//		employeeService.addEmployee(employee2);
//		employeeService.addEmployee(employee3);
//		employeeService.addEmployee(employee4);
//		employeeService.addEmployee(employee5);
//		System.out.println("added employees");
		
		//Sets the manager and saves the updates
		Employee Boss = employeeService.findByName("Ana", "Murillo");
		Employee employee1 = employeeService.findByName("Victor", "Chanto");
		employee1.setManager(Boss);
		employeeService.addEmployee(employee1);
		Employee employee2 = employeeService.findByName("Alex", "Chavarria");
		employee2.setManager(Boss);
		employeeService.addEmployee(employee2);
		Employee employee3 = employeeService.findByName("Rodolfo", "Avalos");
		employee3.setManager(Boss);
		employeeService.addEmployee(employee3);
		Employee employee4 = employeeService.findByName("Javier", "Villalobos");
		employee4.setManager(Boss);
		employeeService.addEmployee(employee4);
		
		
		//Implement a getter method that will allow a manager to get all their employees.
		for(Employee e : Boss.getEmployees()) {
			System.out.println("Employee: " + e.getFirstName() + " " + e.getLastName());
		}
		
		// Implement a getter method that will allow an employee to get thier manager
		System.out.println("Manager: " + employeeService.findByName("Rodolfo", "Avalos").getManager().getFirstName());
		return "index";
	}

}
