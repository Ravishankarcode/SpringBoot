package com.example.log4j2;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.log4j2.service.EmployeeService;

@SpringBootApplication
public class Log4j2Application {

	private static final Logger LOGGER = LogManager.getLogger(Log4j2Application.class);
	
    @Autowired
    private EmployeeService employeeService;
    
	public static void main(String[] args) {
		SpringApplication.run(Log4j2Application.class, args);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
 
        	LOGGER.info("Calling GetEmployeeId Method "+ employeeService.getEmployeeById(4));
 
        };
    }

}
