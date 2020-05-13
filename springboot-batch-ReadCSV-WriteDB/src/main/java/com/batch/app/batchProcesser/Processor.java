package com.batch.app.batchProcesser;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.app.model.Employee;

@Component
public class Processor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee employee) throws Exception {
		System.out.println("Processor is running...");
		return employee;
	}

}