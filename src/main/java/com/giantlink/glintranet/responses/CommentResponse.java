package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {
	private Long id;

	private String content;

	private Date commentDate;
	
	private EmployeeCommentRes employeeCommentResponse;
}
