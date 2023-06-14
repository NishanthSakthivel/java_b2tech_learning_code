package com.nish.springrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nish.springrestapi.model.Employee;
import com.nish.springrestapi.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo eRepo;

	@Override
	public List<Employee> getEmployees(int pageNumber, int pageSize) {
		Pageable pages=PageRequest.of(pageNumber, pageSize,Direction.ASC,"id");

		return eRepo.findAll(pages).getContent();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepo.save(employee);
		
	}

	@Override
	public Employee getEmployeebyId(Long id) {
		Optional<Employee> employeeResult=eRepo.findById(id);
		if(employeeResult.isPresent()) {
			return employeeResult.get();
		}
		else {
			throw new RuntimeException("Employee not found fro the id "+ id);
		}
	//	return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		eRepo.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		 return eRepo.save(employee);
		
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		
		return eRepo.findByName(name);
	}

	@Override
	public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
		return eRepo.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeeByKeyword(String name) {
		Sort sort=Sort.by(Sort.Direction.DESC, "id");
		return eRepo.findByNameContaining(name,sort);
	}

	@Override
	public List<Employee> getEMployeeByNameOrLocation(String name, String location) {
		return eRepo.getEmployeeByNameAndLocation(name, location);
	}

	@Override
	public Integer deleteByEmployeeByName(String name) {
		return eRepo.deleteEmployeebyName(name);
	}

}
