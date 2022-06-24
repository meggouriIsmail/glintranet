package com.giantlink.glintranet.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamResSimplified {

	
	private Long id;
	private String name;
	private String description;
}
