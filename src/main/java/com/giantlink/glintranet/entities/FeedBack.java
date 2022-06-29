package com.giantlink.glintranet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "feedback")
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor @Builder
public class FeedBack 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max = 150)
	private String content;
	
	@CreationTimestamp
	private Date timestamp;
	
	@ManyToOne()
	@JoinColumn(name = "type_id", nullable = false)
	@JsonBackReference
	private FeedBackType type;
	
	@ManyToOne()
	@JoinColumn(name = "project_id", nullable = false)
	@JsonBackReference
	private Project project;
	
	@ManyToOne()
	@JoinColumn(name = "employee_id", nullable = false) 
	@JsonBackReference
	private Employee employee;
}
