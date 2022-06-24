package com.giantlink.glintranet.responses;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
	
	private EmployeeResSimplified employee;
	
	private SectionResponse section;

	private List<CommentResponse> comments;
	
	private Set<Tag> tags;
}
