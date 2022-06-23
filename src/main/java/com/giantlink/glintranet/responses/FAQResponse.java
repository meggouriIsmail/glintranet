package com.giantlink.glintranet.responses;

import java.util.Date;
import java.util.Set;

import com.giantlink.glintranet.entities.Employee;
import com.giantlink.glintranet.entities.Tag;

import lombok.Builder;
import lombok.Data;

@Data  @Builder
public class FAQResponse 
{
	private Long id;
	
	private String content;
	
	private String description;
	
	private Date postingDate;
	
	private int votes;
	
	private Boolean status;
	
	private Employee employee;
	
	private Set<Tag> tags;
}
