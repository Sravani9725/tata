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
@Table(name="recharge_tbl")
@Data
@NoArgsConstructor
public class Recharge {
	@Id
	private long rechargeId;
	
	private double amount;
}
