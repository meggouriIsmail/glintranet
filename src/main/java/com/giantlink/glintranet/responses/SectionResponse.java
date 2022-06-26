package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.Builder;
import lombok.Data;


@Data @Builder
public class SectionResponse 
{	
	private Long id;
	private String name;
	private Date timestamp;

}
