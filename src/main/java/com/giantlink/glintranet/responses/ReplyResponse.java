package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReplyResponse {
	private Long id;

	private String content;

	private Date replyDate;

	private EmployeeCommentRes employeeCommentResponse;
}
