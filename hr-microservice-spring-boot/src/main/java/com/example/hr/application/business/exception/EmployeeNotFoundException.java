package com.example.hr.application.business.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {

	private final String identity;

	public EmployeeNotFoundException(String identity) {
		super("Employee does not exist.");
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
