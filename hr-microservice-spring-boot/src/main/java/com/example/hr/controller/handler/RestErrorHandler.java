package com.example.hr.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.hr.application.business.exception.EmployeeNotFoundException;
import com.example.hr.dto.error.RestErrorMessage;

@RestControllerAdvice
public class RestErrorHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RestErrorMessage handleEmployeeNotFoundException(EmployeeNotFoundException e) {
		return new RestErrorMessage(e.getMessage());
	}
}
