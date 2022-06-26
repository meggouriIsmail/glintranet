package com.giantlink.glintranet.responses;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class DocTypeResponse 
{
	private Long id;
	
	private String name;
}
