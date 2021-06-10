package com.cg.pack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_tbl")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "uname")
	@NotNull
	@Size(min = 4, message = "User name should have minimum four characters!!")
	private String username;
	
	@Column(name = "fname")
	@NotNull
	@Size(min = 2, message = "First Name should have mininum 2 characters!!")
	private String firstName;
	
	@Column(name = "lname")
	@NotNull
	@Size(min = 2, message = "Last Name should have minimum 2 characters!")
	private String lastName;
	
	@Column(name = "password")
	@NotNull
	@Size(min = 8, message = "Password should have minimum 8 characters!")
	private String password;
	
	@OneToOne
	private Account account;
}
