package com.example.Employee.dto;



public class EmployeeDto {
	
	
	private String name;
	
	
	private String designation;
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "EmployeeDto [name=" + name + ", designation=" + designation + "]";
	}

}
