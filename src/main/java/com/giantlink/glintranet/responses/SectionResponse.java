package com.giantlink.glintranet.responses;

import java.util.Date;
import java.util.Set;

import com.giantlink.glintranet.entities.FAQ;

import lombok.Builder;
import lombok.Data;


@Data @Builder
public class SectionResponse 
{	
	private Long id;
	private String name;
	private Date timestamp;

}
