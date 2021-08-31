package com.example.Employee.exception;

public class NullPointerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String message;


	public NullPointerException(String message) {
		super();
		this.message = message;
	}


	public NullPointerException() {
		super();
	}
	
	
}
