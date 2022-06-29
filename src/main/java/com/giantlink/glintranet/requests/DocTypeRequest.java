package com.giantlink.glintranet.requests;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
public class DocTypeRequest 
{	
	private String name;
}
