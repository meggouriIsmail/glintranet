package com.giantlink.glintranet.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "comment")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Comment 
{
	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp
	private Date commentDate;

	@ManyToOne
	@JoinColumn(name = "faq_id")
	@JsonBackReference
	private FAQ faq;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	@JsonBackReference
	private Employee employee;

	@OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonBackReference
	private Set<Reply> replies;
}
