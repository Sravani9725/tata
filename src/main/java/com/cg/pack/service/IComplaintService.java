package com.cg.pack.service;

import java.util.List;

import com.cg.pack.entities.Complaint;
import com.cg.pack.exception.ComplaintNotFoundException;


public interface IComplaintService {

	void addComplaint(Complaint compl);//User
	
	List<Complaint> fetchAll();//Admin
	
	void delComplaint(long id) throws ComplaintNotFoundException;

	Complaint fetchById(Long id) throws ComplaintNotFoundException;
	
	
	
}
