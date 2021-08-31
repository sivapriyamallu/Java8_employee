package com.example.Employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Employee.exception.EmployeeNotFoundException;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;


@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
	
	@Mock
	EmployeeService employeeservice;
	
	@InjectMocks
	EmployeeController employeecontroller;
	
	
	static Employee employee;
	static List<Employee> employees;
	
	@BeforeAll
	public static void setUp() {
		employee = new Employee();
		employee.setAge(23);
		employee.setDesignation("Software Engineer");
		employee.setId(1);
		employee.setName("Sivapriya");
		employee.setPhoneno(939863342);
		employee.setSalary(82000);
		
		employees = new ArrayList<Employee>();
		employees.add(employee);
		
	}
	

	@Test
	@DisplayName("Employee Insert: Positive Scenario")
	public void SaveEmployee() throws EmployeeNotFoundException {
		//given or context
		ResponseEntity<List<Employee>> insert = employeeservice.save(employees);
		//when or event
		ResponseEntity<?> result = employeecontroller.save(employees);
		
		//then or outcome
		assertEquals(insert, result);
	}
	
	@Test
	@DisplayName("Employee Insert:Negative Scenario")
	public void SaveEmployee1() throws EmployeeNotFoundException {
		//given or context
		when(employeeservice.save(employees)).thenThrow(EmployeeNotFoundException.class);
		
		//when or event
		//ResponseEntity<?> result = employeecontroller.save(employees);
		
		//then or outcome
		assertThrows(EmployeeNotFoundException.class, ()->employeecontroller.save(employees));
	}
	
	
	@Test
	@DisplayName("Search Employee above 50k salary")
	public void SearchEmployee() throws EmployeeNotFoundException {
		//given or, context
		 ResponseEntity<List<Employee>> salary = employeeservice.filtersalary();
		
		//when
		ResponseEntity<?> result = employeecontroller.filtersalaryabove50k();
		
		//then or, outcome
		
	assertEquals(result,salary);
		
	}
	
	@Test
	@DisplayName("Search Employee below 20k salary")
	public void SearchEmployee1() throws EmployeeNotFoundException {
		//given or, context
		 ResponseEntity<List<Employee>> salary = employeeservice.filterbysalary();
		
		//when
		ResponseEntity<?> result = employeecontroller.filterbysalarybelow20k();
		
		//then or, outcome
		
	assertEquals(result,salary);
		
	}
	
	@Test
	@DisplayName("Search Employee to be incremented")
	public void SearchEmployee2() throws EmployeeNotFoundException {
		//given or, context
		 ResponseEntity<List<Employee>> salary = employeeservice.salaryincrement();
		
		//when
		ResponseEntity<?> result = employeecontroller.salaryincrement();
		
		//then or, outcome
		
	assertEquals(result,salary);
		
	}

}
