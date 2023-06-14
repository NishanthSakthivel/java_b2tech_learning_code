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

//@Controller
@RestController // combination of @Controller and @ResponseBody
//@RequestMapping("/api/v1")// class level endpoint  localhost:8080/api/v1/../// added from properties
public class EmployeeController {
	
	@Autowired
	private EmployeeService empServie;
	
	

	// @RequestMapping(value="/employees", method=RequestMethod.GET)
	// @ResponseBody
	@GetMapping(value = "/employees") // @RequestMapping not required
	public ResponseEntity<List<Employee>>getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {

		return new ResponseEntity<List<Employee>> (empServie.getEmployees(pageNumber,pageSize),HttpStatus.OK);
	}

	// pass values/information/data from client to server using path variable
	// http://localhost:8080/employees/15
	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee>getEmployee(@PathVariable("id") Long id) {

		return new ResponseEntity<Employee> (empServie.getEmployeebyId(id),HttpStatus.OK);

	}

	// Save Employee
	// we can have same url for multiple methods but different
	// http methods(get/post/put/delete)
	@PostMapping(value = "/employees")
	public ResponseEntity<Employee> SaveEmployee(@Valid  @RequestBody Employee employee) {

		return new ResponseEntity<Employee>(empServie.saveEmployee(employee),HttpStatus.CREATED);

	}
	
	@PutMapping(value="/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id ,@RequestBody Employee employee) {
		
		employee.setId(id);
		 return empServie.updateEmployee(employee);
	}

	// pass values/information/data from client to server using Requestparam
	// if vsr name inside request param and actual var name are same ,
	// not required to mention ie:@RequestParam Long id... same for pathvariable
	// method also
	// http://localhost:8080/employees?id=15
	@DeleteMapping(value = "/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id) {
		  empServie.deleteEmployee(id);
		  return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeebyName(@RequestParam String name){
		
		return new ResponseEntity<List<Employee>>(empServie.getEmployeeByName(name),HttpStatus.OK);
		
		
	}
	
	@GetMapping("employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>>getEmployeeByNameAndLocation(@RequestParam String name, @RequestParam String location){
		return new ResponseEntity<List<Employee>>(empServie.getEmployeeByNameAndLocation(name, location),HttpStatus.OK);
	}
	@GetMapping("employees/filterBykeyword")
	public ResponseEntity<List<Employee>>getEmployeeByKeyword(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(empServie.getEmployeeByKeyword(name),HttpStatus.OK);
	}
	
	@GetMapping("employees/{name}/{location}")
	public ResponseEntity<List<Employee>>getEmployeebyNameOrLocation(@PathVariable String name,@PathVariable String location){
		return new ResponseEntity<List<Employee>>(empServie.getEMployeeByNameOrLocation(name, location),HttpStatus.OK);
		
	}
	
	@DeleteMapping("employees/delete/{name}")
	public ResponseEntity<Integer>deleteEmployeeByName(@PathVariable String name){
		
		return new ResponseEntity<Integer>(empServie.deleteByEmployeeByName(name),HttpStatus.OK);
		 
	}

}
