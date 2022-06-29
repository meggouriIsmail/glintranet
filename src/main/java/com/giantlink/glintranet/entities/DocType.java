package com.giantlink.glintranet.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "doctype")
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor @Builder
public class DocType {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 3, max = 20) @Column(nullable = false)
	private String name;
	
	@CreationTimestamp
	private Date timestamp;

	/*
	 * @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade =
	 * CascadeType.REMOVE)
	 * 
	 * @JsonBackReference private Set<Document> documents;
	 */
}
