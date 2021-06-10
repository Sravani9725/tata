package com.cg.pack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="serviceReq_tbl")
@NoArgsConstructor
@Data
public class ServiceRequest {
	@Id
	private long serviceRequestId;
	
	private String message;
}
