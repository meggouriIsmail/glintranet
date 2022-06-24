package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {
	private String id;

	private String content;

	private Date commentDate;
}
