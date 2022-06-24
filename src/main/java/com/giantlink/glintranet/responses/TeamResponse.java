	package com.giantlink.glintranet.responses;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamResponse {
	
	private Long id;
	private String name;
	private String description;
	
	private Set<EmployeeResSimplified> employeeResponses;
	
	private Set<ProjectResponse> projectResponses;

}
