package com.example.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.slf4j.service.EmployeeService;

@SpringBootApplication
public class Slf4jApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
    @Autowired
    private EmployeeService employeeService;
    
	public static void main(String[] args) {
		SpringApplication.run(Slf4jApplication.class, args);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
 
        	LOGGER.info("Calling GetEmployeeId Method {}",employeeService.getEmployeeById(1));
 
        };
    }

}
