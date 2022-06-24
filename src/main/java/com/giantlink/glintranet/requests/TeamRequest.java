package com.giantlink.glintranet.requests;

import java.util.Set;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
	
	private String name;
	private String description;
	
	private Set<ProjectRequest> projects;
	
	private Set<EmployeeRequest> employees; 
	
}
