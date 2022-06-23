package com.giantlink.glintranet.requests;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class SectionRequest 
{
	@Size(min = 3, max = 20) @Column(nullable = false)
	private String name;

	private Date timestamp;

}
