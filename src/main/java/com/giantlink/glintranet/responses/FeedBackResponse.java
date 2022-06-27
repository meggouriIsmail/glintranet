package com.giantlink.glintranet.responses;

import java.util.Date;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.FeedBackType;
import com.giantlink.glintranet.entities.Project;

import lombok.Data;

@Data
public class FeedBackResponse 
{
	private Long id;
	
	private String content;
	
	private Date timestamp;
	
	//private Employee employee;
	
	//private Project project;
	
	//private FeedBackType type;
}
