package com.nish.springrestapi.model;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long Id;
	//we can provide alis name by using this annotaton
	//@JsonProperty("full_name")
	@NotBlank(message = "Name should not be null")
	private String name;
	
	//it will skip sendinf age datat in json.. to hide sensitive data twe can use this  
	//@JsonIgnore
	
	private Long age=0L ;
	
	
	private String location;
	
	@Email
	private String email;
	
	@NotBlank(message =  "Department should not be null")
	private String department;
	
	@CreationTimestamp
	@Column(name="created_at",nullable = false,updatable = false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	
	
	


}
