package com.example.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr.application.HrApplication;
import com.example.hr.application.business.exception.EmployeeNotFoundException;
import com.example.hr.entity.Employee;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class HrRestController {
	private final HrApplication hrApplication;

	public HrRestController(HrApplication hrApplication) {
		this.hrApplication = hrApplication;
	}

	@GetMapping("{identity}")
	public Employee getEmployeeById(@PathVariable String identity) {
		return hrApplication.getEmployeeByIdentity(identity)
				            .orElseThrow(() -> new EmployeeNotFoundException(identity));
	}
	
	@GetMapping(params= {"page", "size"})
	public List<Employee> getEmployees(@RequestParam int page,@RequestParam int size) {
		return hrApplication.getEmployees(page, size);
	}
	
	@PostMapping
	public Employee hireEmployee(@RequestBody Employee employee) {
		return hrApplication.hireEmployee(employee);
	}

	@PutMapping("{identity}")
	public Employee updateEmployee(@PathVariable String identity,@RequestBody Employee employee) {
		return hrApplication.updateEmployee(employee);
	}
	
	@DeleteMapping("{identity}")
	public Employee fireEmployee(@PathVariable String identity) {
		return hrApplication.fireEmployee(identity)
				            .orElseThrow(() -> new EmployeeNotFoundException(identity));
	}
}
