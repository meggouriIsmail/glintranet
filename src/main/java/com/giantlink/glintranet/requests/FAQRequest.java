package com.giantlink.glintranet.requests;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.giantlink.glintranet.entities.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class FAQRequest
{

	@Size(max = 150) @Column(nullable = false)
	private String content;
	
	@Size(max = 250)
	private String description;
	
	@Column(nullable = false)
	private Date postingDate;
	
	private int votes;

	@Column(nullable = false)
	private Boolean status;
	
	@NotNull
	private Long employee_id;

	private Long section_id;
	
	private List<Tag> tags;
	
}
