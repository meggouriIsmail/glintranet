package com.giantlink.glintranet.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeCommentRes {
	private String firstName;

	private String lastName;

	private String username;
}
