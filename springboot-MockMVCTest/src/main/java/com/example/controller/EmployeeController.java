package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/getEmp")
	public Employee getEmployee(){
		
		Employee e = new Employee();
		e.seteId("e01");
		e.seteName("Ravi");
		e.seteDesignation("Software Engineer");
		e.seteSalary(50.2);
		
		return e;
		
	}
}
