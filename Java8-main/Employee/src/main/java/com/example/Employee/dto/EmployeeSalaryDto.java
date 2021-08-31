package com.example.Employee.dto;

public class EmployeeSalaryDto {
	
	private String name;
	private double salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeSalaryDto [name=" + name + ", salary=" + salary + "]";
	}
	
	

}
