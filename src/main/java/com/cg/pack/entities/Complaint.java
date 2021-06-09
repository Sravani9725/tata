package com.cg.pack.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "Complaint_Table")
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long complaintId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Account account;
	@Size(min = 3, message = "Complaint should have mininum 2 characters!!")
	@Column(name = "Complaint")
	private String complaint;
	
	


}