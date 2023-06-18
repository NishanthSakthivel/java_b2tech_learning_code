package com.nish.springrestapi.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.nish.springrestapi.Entity.Employee;

public interface EmployeeService {
	
	List<Employee>getEmployees(int pageNumber, int pageSize);
	Employee saveEmployee(Employee employee);
	Employee getEmployeebyId(Long id);
	void deleteEmployee(Long id);
	Employee updateEmployee(Employee employee);
	
	

}
