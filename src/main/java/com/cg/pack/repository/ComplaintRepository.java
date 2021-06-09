package com.cg.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pack.entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
