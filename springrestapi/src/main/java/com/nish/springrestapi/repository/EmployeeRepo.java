package com.nish.springrestapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nish.springrestapi.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	List<Employee> findByName(String name);
	List<Employee> findByNameAndLocation(String name, String location);
	List<Employee>findByNameContaining(String keyword,Sort sort);
	
	@Query("FROM Employee WHERE name =:name OR location=:location")
	List<Employee>getEmployeeByNameAndLocation(String name,String location);
	
	
	@Transactional 
	@Modifying   // for modifying quries 
	@Query("DELETE FROM Employee WHERE name=:name")
	Integer deleteEmployeebyName(String name);
	

}
	