package com.giantlink.glintranet.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.giantlink.glintranet.responses.SectionResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "FAQ")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class FAQ 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max = 150) @Column(nullable = false)
	private String content;
	
	@Size(max = 250)
	private String description;
	
	@CreationTimestamp
	private Date postingDate;
	
	private int votes;
	
	
	@Column(nullable = false)
	private Boolean status;

	@ManyToOne()
	@JoinColumn(name = "employee_id", nullable = false)	@JsonBackReference
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "section_id") @JsonBackReference
	private Section section;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "FAQ_Tags",joinColumns = @JoinColumn(name = "faq_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> Tags;

}
