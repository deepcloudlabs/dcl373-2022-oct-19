package com.example.hr.application.business;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.exception.AlreadyExistingEmployee;
import com.example.hr.application.business.exception.EmployeeNotFoundException;
import com.example.hr.entity.Employee;
import com.example.hr.repository.EmployeeRepository;

@Service
public class StandardHrApplication implements HrApplication {
	private final EmployeeRepository employeeRepository;
	
	public StandardHrApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Optional<Employee> getEmployeeByIdentity(String identity) {
		return employeeRepository.findById(identity);
	}

	@Override
	public List<Employee> getEmployees(int pageNo, int pageSize) {
		return employeeRepository.findAll(PageRequest.of(pageNo, pageSize))
				                 .getContent();
	}

	@Override
	@Transactional
	public Employee hireEmployee(Employee employee) {
		var identity = employee.getIdentity();
		if(employeeRepository.existsById(identity))
			throw new AlreadyExistingEmployee(identity);
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public Optional<Employee> fireEmployee(String identity) {
		var employee =  employeeRepository.findById(identity)
				                 .orElseThrow(() -> new EmployeeNotFoundException(identity));
		employeeRepository.delete(employee);
		return Optional.of(employee);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		var identity = employee.getIdentity(); 
		var managedEmployee =  employeeRepository.findById(identity)
                                   .orElseThrow(() -> new EmployeeNotFoundException(identity));
		managedEmployee.setIban(employee.getIban());
		managedEmployee.setSalary(employee.getSalary());
		managedEmployee.setDepartment(employee.getDepartment());
		managedEmployee.setJobStyle(employee.getJobStyle());
		managedEmployee.setPhoto(employee.getPhoto());
		// employeeRepository.save(managedEmployee);
		return managedEmployee;
	}

}
