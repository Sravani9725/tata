package com.cg.pack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pack_tbl")
@Data
@NoArgsConstructor
public class Pack {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long packId;
	
	@Column(name = "PackName")
	@NotNull
	@Size(min=2,message = "Name Should be Minimum of Two Characters")
	private String packName;
	
	@Column(name = "PackValidity")
	@Size(min=2,message = "Validity name Should be Minimum of Two Characters")
	private String packValidity;
	
	@Column(name = "PackCost")
	public double packCost;
	
	@Column(name = "PackDescription")
	@Size(min=10,message = "Description Should be Minimum of Ten Characters")
	private String packDescription;
	//@Column(name = "Channels")
	//private List<String> channels;

	
}
