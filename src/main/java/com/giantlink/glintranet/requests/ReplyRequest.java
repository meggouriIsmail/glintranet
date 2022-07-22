package com.giantlink.glintranet.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyRequest {
	private String content;

	private Date replyDate;
	
	private Long cmt_Id;
	
	private Long emp_Id;
}
