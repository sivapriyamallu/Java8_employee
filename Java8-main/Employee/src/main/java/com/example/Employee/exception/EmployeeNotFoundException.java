package com.example.Employee.exception;

public class EmployeeNotFoundException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;

	public EmployeeNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EmployeeNotFoundException() {
		super();
	}

	
}
