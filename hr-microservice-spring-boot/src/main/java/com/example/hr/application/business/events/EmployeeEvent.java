package com.example.hr.application.business.events;

import java.util.UUID;

public abstract class EmployeeEvent {
	private final String identity;
	private final EmployeeEventType eventType;
	private final String eventId = UUID.randomUUID().toString();

	public EmployeeEvent(String identity, EmployeeEventType eventType) {
		this.identity = identity;
		this.eventType = eventType;
	}

	public String getIdentity() {
		return identity;
	}

	public String getEventId() {
		return eventId;
	}

	public EmployeeEventType getEventType() {
		return eventType;
	}

	@Override
	public String toString() {
		return "EmployeeEvent [identity=" + identity + ", eventType=" + eventType + ", eventId=" + eventId + "]";
	}

}
