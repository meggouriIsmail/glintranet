package com.giantlink.glintranet.entities;

import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
  
	@Size(min = 3, max = 15)
	@Column(nullable = false)
	private String firstName;

	@Size(min = 3, max = 15)
	@Column(nullable = false)
	private String lastName;

	@Size(min = 4, max = 15)
	@Column(nullable = false)
	private String CIN;

	@Size(min = 5, max = 20)
	@Column(nullable = false)
	private String username;

	@Column(length = 25, nullable = false)
	private String email;

	@Size(min = 8, max = 200)
	@Column(nullable = false)
	private String password;

	@Size(min = 10, max = 12)
	@Column(nullable = false)
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_role",
		joinColumns = @JoinColumn(name = "emp_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	) 
	private Set<Role> roles;

	//@CreationTimestamp
	private String birthDate;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<FAQ> FAQs;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Document> documents;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<FeedBack> feedBacks;
	
	@ManyToOne()
    private Team team;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonBackReference
	private Set<Comment> comments;
	
	@OneToOne(mappedBy = "employee")
	private Reply reply;

}
