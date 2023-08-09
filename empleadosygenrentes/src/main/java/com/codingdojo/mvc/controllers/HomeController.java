package com.codingdojo.mvc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.mvc.models.Employee;
import com.codingdojo.mvc.repositories.EmployeeRepository;

@Controller
public class HomeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
//	INSERT INTO employees (first_name, last_name, manager_id) VALUES ('Luis', 'Uno', NULL);
//
//	SET @manager_id = LAST_INSERT_ID();
//
//	INSERT INTO employees (first_name, last_name, manager_id) VALUES ('Juan', 'Uno', @manager_id);
//	INSERT INTO employees (first_name, last_name, manager_id) VALUES ('Pedro', 'Dos', @manager_id);
	
	@GetMapping("/test")
	public void friends() {
		Optional<Employee> employee = employeeRepository.findById(1L);
		System.out.println("manager: " + employee.get().getFirst_name());

		for (Employee e : employee.get().getEmployees()) {
			System.out.println("empleado: " + e.getFirst_name());
		}
	}
}
