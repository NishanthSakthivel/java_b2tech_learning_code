package com.nish.springrestapi.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.nish.springrestapi.model.Employee;

public interface EmployeeService {
	
	List<Employee>getEmployees(int pageNumber, int pageSize);
	Employee saveEmployee(Employee employee);
	Employee getEmployeebyId(Long id);
	void deleteEmployee(Long id);
	Employee updateEmployee(Employee employee);
	
	List<Employee>getEmployeeByName(String name);
	List<Employee>getEmployeeByNameAndLocation(String name, String location);
	List<Employee>getEmployeeByKeyword(String name);
	List<Employee>getEMployeeByNameOrLocation(String name,String location);
	Integer deleteByEmployeeByName(String name);

}
