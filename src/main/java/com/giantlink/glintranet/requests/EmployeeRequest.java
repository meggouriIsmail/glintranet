package com.giantlink.glintranet.requests;


import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;


@Data @Builder
public class EmployeeRequest 
{
	@Size(min = 3, max = 15)
	@Column(nullable = false)
	private String firstName;
	
	@Size(min = 3, max = 15)
	@Column(nullable = false)
	private String lastName;
	
	@Size(min = 4, max = 15)
	@Column(nullable = false)
	private String CIN;
	
	@Size(min = 5, max = 20)
	@Column(nullable = false)
	private String username;
	
	@Column(length = 25, nullable = false)
	private String email;
	
	@Size(min = 8, max = 20)
	@Column(nullable = false)
	private String password;
	
	@Size(min = 10, max = 12)
	@Column(nullable = false)
	private String phoneNumber;
	

	private Date birthDate;
	

}
