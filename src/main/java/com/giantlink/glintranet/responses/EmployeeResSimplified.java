package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResSimplified {
	private long id;

	private String firstName;

	private String lastName;

	private String CIN;

	private String username;

	private String email;

	private String password;

	private String phoneNumber;

	private String birthDate;
	
	private String role;
}
