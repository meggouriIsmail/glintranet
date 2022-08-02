package com.giantlink.glintranet.entities;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeNotification {
	@EmbeddedId
	private EmpNotifId empNotifId;

	@ManyToOne
	@MapsId("id")
	@JsonIgnore
	private Employee employee;

	@ManyToOne
	@MapsId("id")
	@JsonIgnore
	private Notification notification;

	@CreationTimestamp
	private Date creationDate;
}
