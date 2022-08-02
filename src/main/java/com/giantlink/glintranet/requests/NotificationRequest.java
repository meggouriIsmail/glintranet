package com.giantlink.glintranet.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
	private String content;

	private Boolean isRead;

	private String link;
	
	private Long empl_id;
}
