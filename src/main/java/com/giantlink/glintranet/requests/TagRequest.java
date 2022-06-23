package com.giantlink.glintranet.requests;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class TagRequest 
{
	@Size(min = 3, max = 15) @Column(nullable = false)
	private String name;
	@Size(max = 250)
	private String description;

}
