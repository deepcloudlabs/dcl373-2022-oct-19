package com.example.hr.application.business.exception;

@SuppressWarnings("serial")
public class AlreadyExistingEmployee extends RuntimeException {

	private final String identity;

	public AlreadyExistingEmployee(String identity) {
		super("The employee already exists.");
		this.identity = identity;
	}

	public String getIdentity() {
		return identity;
	}

}
