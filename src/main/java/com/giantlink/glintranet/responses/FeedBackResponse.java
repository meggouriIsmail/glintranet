package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.Data;

@Data
public class FeedBackResponse 
{
	private Long id;
	
	private String content;
	
	private Date timestamp;
	
	private EmployeeResSimplified employee;
	
	private ProjectResponse project;
	
	private FeedBackTypeResponse type;
}
