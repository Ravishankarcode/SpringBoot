package com.example.slf4j.service;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.slf4j.model.Employee;


@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
    static HashMap<Integer, Employee> db = new HashMap<>();
    
    static {
        db.put(1, new Employee(1, "Ravi", "Shankar"));
        db.put(2, new Employee(2, "Dev", "Prakash"));
        db.put(3, new Employee(3, "Sameer", "Kumar"));
    }
     
    public Employee getEmployeeById(int id) {
    	LOGGER.info("Calling Employee by Id::{}",id);
        return db.get(id);
    }
	
}
