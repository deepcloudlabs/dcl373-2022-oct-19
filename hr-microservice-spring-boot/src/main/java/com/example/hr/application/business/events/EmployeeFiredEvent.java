package com.example.hr.application.business.events;

public class EmployeeFiredEvent extends EmployeeEvent {

	public EmployeeFiredEvent(String identity) {
		super(identity, EmployeeEventType.FIRE_EVENT);
	}

}
