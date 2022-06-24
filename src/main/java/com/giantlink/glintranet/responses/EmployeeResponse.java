package com.giantlink.glintranet.responses;



import java.util.Date;
import java.util.Set;

import com.giantlink.glintranet.entities.FAQ;
import com.giantlink.glintranet.entities.Team;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmployeeResponse 
{
	private long id;
	
	private String firstName;
	
	private String lastName;

	private String CIN;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String phoneNumber;
	
	private Date birthDate;
	
	private Set<FAQ> FAQs;

	private TeamResSimplified team;
	
}
