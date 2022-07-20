package com.giantlink.glintranet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reply")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp
	private Date replyDate;

	@ManyToOne
	@JoinColumn(name = "cmt_id")
	@JsonBackReference
	private Comment comment;
	
	@OneToOne
	private Employee employee;
}
