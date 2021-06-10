package com.cg.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pack.entities.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long>{

}
