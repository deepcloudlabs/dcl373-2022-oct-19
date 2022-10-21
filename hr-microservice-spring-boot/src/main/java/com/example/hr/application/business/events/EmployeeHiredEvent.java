package com.example.hr.application.business.events;

public class EmployeeHiredEvent extends EmployeeEvent {

	public EmployeeHiredEvent(String identity) {
		super(identity, EmployeeEventType.HIRE_EVENT);
	}

}
