package com.example.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hr.entity.Department;
import com.example.hr.entity.Employee;
import com.example.hr.entity.JobStyle;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	List<Employee> findAllByDepartment(Department department);

	List<Employee> findAllByDepartmentAndJobStyle(Department department, JobStyle jobStyle);

	@Query("select e from Employee e where e.department=:department and e.jobStyle=:jobStyle")
	List<Employee> apple(Department department, JobStyle jobStyle);

	@Query(nativeQuery = true, value = "select e from employees e where e.department=:department and e.jobstyle=:jobStyle")
	List<Employee> getir(Department department, JobStyle jobStyle);
}
