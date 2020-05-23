package com.example.MockMVCTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class EmployeeTest extends MockMvcTestApplicationTests{

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before	
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	//http://localhost:8085/getEmp
	//{"eId":"e01","eName":"Ravi","eDesignation":"Software Engineer","eSalary":50.2}
	@Test
	public void testEmployee() throws Exception{
		
		mockMvc.perform(get("/getEmp")).andExpect(status().isOk())
		       .andExpect(jsonPath("$.eId").value("e01"))
		       .andExpect(jsonPath("$.eName").value("Ravi"));
	}
}
