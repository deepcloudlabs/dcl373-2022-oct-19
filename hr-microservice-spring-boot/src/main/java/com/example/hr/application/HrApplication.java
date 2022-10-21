package com.example.hr.application;

import java.util.List;
import java.util.Optional;

import com.example.hr.entity.Employee;

public interface HrApplication {
	Optional<Employee> getEmployeeByIdentity(String identity);

	List<Employee> getEmployees(int pageNo, int pageSize);

	Employee hireEmployee(Employee employee);

	Optional<Employee> fireEmployee(String identity);

	Employee updateEmployee(Employee employee);
}
