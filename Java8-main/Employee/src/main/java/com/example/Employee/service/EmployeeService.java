package com.example.Employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Employee.exception.EmployeeNotFoundException;
import com.example.Employee.model.Employee;

@Service
public interface EmployeeService {

	public ResponseEntity<List<Employee>> save(List<Employee> employeedto) throws EmployeeNotFoundException;
	
	public ResponseEntity<List<Employee>> filtersalary() throws EmployeeNotFoundException;
	
	public ResponseEntity<List<Employee>> filterbysalary() throws EmployeeNotFoundException;
	
	public ResponseEntity<List<Employee>> salaryincrement() throws EmployeeNotFoundException;
}
