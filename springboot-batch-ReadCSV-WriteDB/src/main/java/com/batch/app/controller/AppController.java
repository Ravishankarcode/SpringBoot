package com.batch.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.batch.app.model.Employee;
import com.batch.app.service.EmployeeService;

@RestController
public class AppController {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/load")
	private ModelAndView load() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {

		ModelAndView mv = new ModelAndView();
		Map<String, JobParameter> parameters = new HashMap<>();
		parameters.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(parameters);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		System.out.println(jobExecution.getStatus());
		mv.setViewName("index");
		mv.addObject("msg", "file data has been successfully stored! ");
		return mv.addObject("status", jobExecution.getStatus().toString());

	}

	@GetMapping("/getData")
	public ModelAndView showCities() {

		ModelAndView mv = new ModelAndView();
		List<Employee> listData = employeeService.getComleteData();
		if (listData.isEmpty()) {
			mv.setViewName("index");
			mv.addObject("nodataMsg", "NO Data FOUND!!");
		} else {
			mv.setViewName("index");
			mv.addObject("employees", listData);

		}

		return mv;
	}

	@GetMapping(value = "/test")
	private ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
		return mv;
	}
}
