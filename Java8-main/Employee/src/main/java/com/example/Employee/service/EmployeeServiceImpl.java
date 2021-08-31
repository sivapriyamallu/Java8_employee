package com.example.Employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Employee.GlobalLogger;
import com.example.Employee.controller.EmployeeController;
import com.example.Employee.dao.EmployeeDao;
import com.example.Employee.dto.EmployeeDto;
import com.example.Employee.dto.EmployeeSalaryDto;
import com.example.Employee.exception.EmployeeNotFoundException;
import com.example.Employee.model.Employee;

import io.swagger.annotations.ApiOperation;

@ApiOperation(tags = "EmployeeService", value = "service")
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Logger logger = GlobalLogger.getLogger(EmployeeService.class);

	@Autowired
	EmployeeDao employeedao;

	// Saving Employee based on condition
	@Override
	public ResponseEntity<List<Employee>> save(List<Employee> employeedto) throws EmployeeNotFoundException {

		logger.info("Getting input from user");
		List<Employee> result = new ArrayList<Employee>();

		for (Employee s1 : employeedto) {
			String s2 = String.valueOf(s1.getPhoneno());
			//System.out.println(s2.length());
			logger.info("Sorting Employee based on criteria");
			if (s1.getAge() > 18 && s2.length() == 13) {
				result.add(s1);
				logger.info("Saved Data to database");
				employeedao.save(s1);
			}
			System.out.println(s1);

		}

		return new ResponseEntity<List<Employee>>(result, HttpStatus.ACCEPTED);

	}

	// Get employee above 50000 salary
	@Override
	public ResponseEntity<List<Employee>> filtersalary() throws EmployeeNotFoundException {

		logger.info("Get All Employees");
		List<Employee> employees = employeedao.findAll();

		logger.info("Filtering of employees");
		if (employees != null) {
			List<String> result = employees.stream().filter(x -> x.getSalary() > 50000).map(x -> x.getName())
					.collect(Collectors.toList());

			System.out.println(result);
			return new ResponseEntity<List<Employee>>(HttpStatus.ACCEPTED);
		}
		throw new EmployeeNotFoundException("No Details here");
	}

	// Get Employee below 20000 salary
	@Override
	public ResponseEntity<List<Employee>> filterbysalary() throws EmployeeNotFoundException {

		logger.info("Getting all employees");
		List<Employee> employees = employeedao.findAll();
		logger.info("Filter on employee below 20k");
		if (employees != null) {
			List<Employee> result = employees.stream().filter(x -> x.getSalary() < 20000).collect(Collectors.toList());

			List<EmployeeDto> employees1 = new ArrayList<EmployeeDto>();

			for (Employee e1 : result) {
				EmployeeDto employee = new EmployeeDto();
				logger.info("copy property from Employee to Dto");
				BeanUtils.copyProperties(e1, employee);
				logger.info("Adding to EmployeeDto list");
				employees1.add(employee);

			}
			System.out.println(employees1);

			return new ResponseEntity<List<Employee>>(HttpStatus.CONTINUE);

		}
		throw new EmployeeNotFoundException("Employee Not Found");
	}

	@Override
	public ResponseEntity<List<Employee>> salaryincrement() throws EmployeeNotFoundException {

		logger.info("Get All Employee");
		List<Employee> employees = employeedao.findAll();

		logger.info("Filter of Employees");
		List<Employee> result = employees.stream().filter(x -> x.getSalary() < 20000).collect(Collectors.toList());
		if (result != null) {
			List<EmployeeSalaryDto> employees2 = new ArrayList<EmployeeSalaryDto>();

			logger.info("Display name and salary of incremented person");
			for (Employee e1 : result) {
				EmployeeSalaryDto employee = new EmployeeSalaryDto();
				e1.setSalary(e1.getSalary() + 10000);
				BeanUtils.copyProperties(e1, employee);
				employees2.add(employee);

			}

			employees2.forEach(System.out::println);

			return new ResponseEntity<List<Employee>>(HttpStatus.OK);

		}
		throw new EmployeeNotFoundException("Employee Not Found");
	}

}
