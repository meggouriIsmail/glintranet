package com.giantlink.glintranet.responses;

import java.util.List;

import lombok.Data;

@Data
public class ReportingResponse 
{
	public int totFAQs;
	
	public int totDocs;
	
	public int totComment;
	
	public int totProjects;
	
	public List<Object> reports;

}
