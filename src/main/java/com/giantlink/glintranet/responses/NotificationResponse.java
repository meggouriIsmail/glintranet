package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {
	private Long id;

	private String content;
	
	private Boolean isRead;

	private Date creationDate;

	private String link;
	
	private EmployeeCommentRes employee;
}
