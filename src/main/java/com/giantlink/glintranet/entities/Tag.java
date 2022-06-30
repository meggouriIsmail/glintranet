 package com.giantlink.glintranet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "tag")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Tag 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Size(min = 3, max = 15) @Column(nullable = false)
	private String name;
	@Size(max = 250)
	private String description;

}
