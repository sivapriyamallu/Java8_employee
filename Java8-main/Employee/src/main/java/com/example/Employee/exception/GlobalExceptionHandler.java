package com.example.Employee.exception;


import java.time.LocalDateTime;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Employee.ApiStatusCode;




@RestControllerAdvice
public class GlobalExceptionHandler {

	
	

	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(EmployeeNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(ApiStatusCode.EMPLOYEE_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(EmployeeNotSavedException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(EmployeeNotSavedException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(ApiStatusCode.USER_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNAUTHORIZED);
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(NullPointerException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(ApiStatusCode.NULL_VALUE);
		errorResponse.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.UNAUTHORIZED);
	}
	

	
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(MethodArgumentNotValidException ex) {
		
		ValidationErrorResponse errorResponse = new ValidationErrorResponse();
		errorResponse.setMessage("Input Data is Invalid");
		errorResponse.setDateTime(LocalDateTime.now());
		errorResponse.setStatuscode(400);
		
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		errors.forEach(error -> {
			errorResponse.getErrorsMap().put(error.getField(), error.getDefaultMessage());
		});
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ConstraintViolationException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatuscode(400);
		errorResponse.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.OK);
	}

}
