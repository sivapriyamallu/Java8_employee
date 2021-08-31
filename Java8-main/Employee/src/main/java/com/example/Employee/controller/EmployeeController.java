package com.example.Employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.GlobalLogger;
import com.example.Employee.exception.EmployeeNotFoundException;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;


import io.swagger.annotations.ApiOperation;



@ApiOperation(value = "/employees", tags = "EmployeeController")
@RestController
public class EmployeeController {

	private Logger logger = GlobalLogger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeservice;

	@PostMapping("/saveemployee")
	public ResponseEntity<List<Employee>> save(@RequestBody List<Employee> employeedto)
			throws EmployeeNotFoundException {

		logger.info("passing data to save method ");
		return employeeservice.save(employeedto);

	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> filtersalaryabove50k() throws EmployeeNotFoundException {
		logger.info("Getting searched data of above 50K");
		return employeeservice.filtersalary();

	}

	@GetMapping("/filteremployees")
	public ResponseEntity<List<Employee>> filterbysalarybelow20k() throws EmployeeNotFoundException {
		logger.info("Getting searched data of below 20k");
		return employeeservice.filterbysalary();
	}

	@GetMapping("/salaryincrement")
	public ResponseEntity<List<Employee>> salaryincrement() throws EmployeeNotFoundException {
		logger.info("Increment of Employee below 20k");
		return employeeservice.salaryincrement();
	}

}
