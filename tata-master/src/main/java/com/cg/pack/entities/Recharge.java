package com.cg.pack.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recharge_tbl")
@Data
@NoArgsConstructor
public class Recharge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rechargeid")
	private long rechargeid;

	@Column(name = "amount")
	private double amount;

	@Column(name = "daysvalidity")
	private int daysValidity;

	@Column(name = "plandescription")
	private String planDescription;

	@Column(name = "planname")
	private String planName;

	@Column(name = "purchaseddate")
	private LocalDate purcahsedDate;
	
	@ElementCollection
	private List<String> channels;
	
//	@ElementCollection
//	private Pack pack;
	
	@ManyToOne
	 Account account;
}
