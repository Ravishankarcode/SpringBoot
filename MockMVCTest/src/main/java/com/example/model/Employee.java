package com.example.model;

public class Employee {

	private String eId;
	private String eName;
	private String eDesignation;
	private double eSalary;
	
	
	public Employee() {

	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteDesignation() {
		return eDesignation;
	}
	public void seteDesignation(String eDesignation) {
		this.eDesignation = eDesignation;
	}
	public double geteSalary() {
		return eSalary;
	}
	public void seteSalary(double eSalary) {
		this.eSalary = eSalary;
	}
	
	
}
