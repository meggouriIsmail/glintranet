package com.giantlink.glintranet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EmployeeFaqId implements Serializable
{
	@Column
	private long employee_id;
	
	@Column
	private long faq_id;
}
