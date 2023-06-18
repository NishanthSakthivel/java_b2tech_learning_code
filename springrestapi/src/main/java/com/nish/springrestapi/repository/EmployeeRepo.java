package com.nish.springrestapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nish.springrestapi.Entity.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	
	

}
	