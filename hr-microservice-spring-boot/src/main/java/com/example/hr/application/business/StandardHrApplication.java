package com.example.hr.application.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.entity.Employee;

@Service
public class StandardHrApplication implements HrApplication {

	@Override
	public Optional<Employee> getEmployeeByIdentity(String identity) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Employee> getEmployees(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee hireEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> fireEmployee(String identity) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
