package com.giantlink.glintranet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "document")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Document 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String documentName;
	
	private String contentType;
	
	private Long size;
	
	@CreationTimestamp
	private Date creationDate;
	
	@Lob
	private byte[] data;
	
	@ManyToOne()
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	@ManyToOne()
	@JoinColumn(name = "doctype_id", nullable = false)
	private DocType type;
}
