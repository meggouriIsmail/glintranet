package com.giantlink.glintranet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EmployeeFAQ 
{
	@EmbeddedId
	private EmployeeFaqId employeeFaqId;
	
	@ManyToOne
	@MapsId("id")
	@JsonIgnore
	private Employee employee;
	
	@ManyToOne
	@MapsId("id")
	@JsonIgnore
	private FAQ faq;
	
	@Column
	private boolean voted_up;
	
	@Column
	private boolean voted_down;
	
	@CreationTimestamp
	private Date creationDate;
}
