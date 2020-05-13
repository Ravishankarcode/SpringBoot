package com.properties.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.properties.demo.component.AppProperties;

/**
 * 
 * @author Ravishankar.kumar
 *
 */
@RestController
@RequestMapping("app")
public class PropertiesReadingController {

	// 1) Read application.properties Using the Environment
	@Autowired
	private Environment env;	
	
	// 2) Reading Properties with @Value Annotation
	
	@Value("${app.title}")
	private String appTitle;
	
	// 3) Reading Application Properties with @ConfigurationProperties
	@Autowired
	AppProperties myAppProperties;
	
	 @GetMapping("/")
	 public String getMessage() {
		 String keyValue = env.getProperty("app.title");
		 System.out.println("Key Value using Environment ::" + keyValue);
		 System.out.println("Key Value using @Value ::"+ appTitle);
		 System.out.println("Key Value using @ConfigurationProperties ::"+ myAppProperties.getTitle());
		 return "API Working! Check your Console for Output!";
	 }
	 

}
