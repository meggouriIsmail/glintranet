package com.giantlink.glintranet.responses;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FAQResSimplified {

	private Long id;

	private String content;

	private String description;

	private Date postingDate;

	private int votes;

	private Boolean status;
}
