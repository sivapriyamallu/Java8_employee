package com.example.Employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import com.example.Employee.dao.EmployeeDao;
import com.example.Employee.exception.EmployeeNotFoundException;
import com.example.Employee.model.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@Mock
	EmployeeDao employeedao;
	
	@InjectMocks
	EmployeeServiceImpl employeeservice;
	

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
	public void saveEmployee() throws EmployeeNotFoundException {
	 
		//given or context
		employeedao.save(employee);
		//when(employees.add(employee)).thenReturn(true);
		
		//when
		ResponseEntity<List<Employee>> result = employeeservice.save(employees);
		
		//outcome
		assertEquals (result.getStatusCode(),HttpStatus.ACCEPTED);
		
	}
	
	
	@Test
	@DisplayName("Filter above 50000")
	public void search() throws EmployeeNotFoundException {
		//given or, context
		when(employeedao.findAll()).thenReturn(employees);
		
		//when
		ResponseEntity<List<Employee>> employees = employeeservice.filtersalary();
	
	    //outcome
		assertEquals(HttpStatus.ACCEPTED, employees.getStatusCode());
	}
	

//	@Test
//	@DisplayName("Search Employee based on above 50k salary")
//	public void SearchEmployee() throws EmployeeNotFoundException {
//		//given or, context
//		when(employeedao.save(employee)).thenThrow(EmployeeNotFoundException.class);
//		
//		//when
//		//ResponseEntity<?> result = employeeservice.filtersalary();
//		
//		
//		//then or outcome
//	      assertThrows(EmployeeNotFoundException.class, ()->employeeservice.filtersalary());
//		
//	}
	
	@Test
	@DisplayName("Filter below 20000")
	public void search1() throws EmployeeNotFoundException {
		//given or, context
		when(employeedao.findAll()).thenReturn(employees);
		
		//when
		ResponseEntity<List<Employee>> employees = employeeservice.filterbysalary();
	
	    //outcome
		assertEquals(HttpStatus.CONTINUE, employees.getStatusCode());
	}
	
	@Test
	@DisplayName("Salary Increment")
	public void search2() throws EmployeeNotFoundException  {
		//given or, context
		when(employeedao.findAll()).thenReturn(employees);
		
		//when
		ResponseEntity<List<Employee>> employees = employeeservice.salaryincrement();
	
	    //outcome
		assertEquals(HttpStatus.OK, employees.getStatusCode());
	}

}
