package com.giantlink.glintranet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpNotifId implements Serializable {

	@Column
	private long employee_id;
	
	@Column
	private long notification_id;
}
