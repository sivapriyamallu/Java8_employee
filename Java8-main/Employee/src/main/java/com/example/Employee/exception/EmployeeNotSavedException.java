package com.example.Employee.exception;

public class EmployeeNotSavedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;

	public EmployeeNotSavedException(String message) {
		super();
		this.message = message;
	}

	public EmployeeNotSavedException() {
		super();
	}
	
	

}
