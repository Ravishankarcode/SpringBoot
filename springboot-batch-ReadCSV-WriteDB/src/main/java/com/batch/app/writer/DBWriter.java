package com.batch.app.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.app.model.Employee;
import com.batch.app.repo.EmployeeRepo;

@Component
public class DBWriter implements ItemWriter<Employee> {

	@Autowired
	private EmployeeRepo employeeRepository;

	@Override
	public void write(List<? extends Employee> employees) throws Exception {

		System.out.println("Data Saved for Employees: " + employees);
		employeeRepository.saveAll(employees);
	}

}
