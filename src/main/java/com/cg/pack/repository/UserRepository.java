package com.cg.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pack.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User getByUsername(String username);



}
