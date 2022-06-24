package com.giantlink.glintranet.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponse {

	private Long id;
	private String projectName;
	private String projectDesc;

}
