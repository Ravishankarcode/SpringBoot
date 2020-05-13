package com.batch.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch.app.model.Employee;
import com.batch.app.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getComleteData() {

		return employeeRepo.findAll();

	}

}
