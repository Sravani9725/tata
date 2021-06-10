package com.cg.pack.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name= "acc_tbl")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;
	
	@NotNull
	@OneToOne
	private User user;
	
//	@OneToMany(mappedBy = "account", targetEntity = Recharge.class, cascade = CascadeType.ALL)
////	@JoinColumn(name = "rc_fk", referencedColumnName = "rechargeId")
	@OneToMany(mappedBy = "rechargeid",cascade = CascadeType.ALL)
	private List<Recharge> recharges;
	
//	@Column(name="registeredDate")
//	@NotNull
//	private LocalDate registeredDate;
	
//	@OneToMany(targetEntity = ServiceRequest.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "sc_fk", referencedColumnName = "serviceRequestId")
//	private List<ServiceRequest> requests;
	
//	@OneToMany(targetEntity=Pack.class, cascade=CascadeType.ALL)
//	@JoinColumn(name="pc_fk",referencedColumnName = "packId")
    @OneToMany(mappedBy = "packId", cascade = CascadeType.ALL)	
	private List<Pack> currentPacks;
	
	@OneToMany(mappedBy="complaintId")
	private List<Complaint> complaints;
//	
	
}
