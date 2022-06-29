package com.giantlink.glintranet.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FeedBackRequest 
{
	private String content;
	
	private Long type_id;
	
	private Long project_id;
	
	private Long employee_id;
}
