package com.nish.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nish.springrestapi.model.Employee;
import com.nish.springrestapi.service.EmployeeService;

import jakarta.validation.Valid;

@RestController // combination of @Controller and @ResponseBody
public class EmployeeController {

	@Autowired
	private EmployeeService empServie;

	@GetMapping(value = "/employees") // @RequestMapping not required
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber,
			@RequestParam Integer pageSize) {

		return new ResponseEntity<List<Employee>>(empServie.getEmployees(pageNumber, pageSize), HttpStatus.OK);
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {

		return new ResponseEntity<Employee>(empServie.getEmployeebyId(id), HttpStatus.OK);

	}

	@PostMapping(value = "/employees")
	public ResponseEntity<Employee> SaveEmployee(@Valid @RequestBody Employee employee) {

		return new ResponseEntity<Employee>(empServie.saveEmployee(employee), HttpStatus.CREATED);

	}

	@PutMapping(value = "/employees /{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

		employee.setId(id);
		return empServie.updateEmployee(employee);
	}

	@DeleteMapping(value = "/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
		empServie.deleteEmployee(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
