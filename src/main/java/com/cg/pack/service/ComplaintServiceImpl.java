package com.cg.pack.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pack.entities.Complaint;
import com.cg.pack.exception.ComplaintNotFoundException;
import com.cg.pack.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements IComplaintService {
	
	Logger logger = LoggerFactory.getLogger(ComplaintServiceImpl.class);

	@Autowired
	private ComplaintRepository repository;
	
	@Override
	public void addComplaint(Complaint compl) {
		logger.info("Complaint has registered");
		repository.save(compl);
		
	}

	@Override
	public List<Complaint> fetchAll() {
		
		return repository.findAll();
	}

	@Override
	public void delComplaint(long id) throws ComplaintNotFoundException{
		Optional<Complaint> complaint = repository.findById(id);
		if (!complaint.isPresent())
			throw new ComplaintNotFoundException();

		repository.deleteById(id);
	}


	@Override
	public Complaint fetchById(Long id) throws ComplaintNotFoundException {
		Optional<Complaint> complaint = repository.findById(id);
		if (!complaint.isPresent())
			throw new ComplaintNotFoundException();

		return complaint.get();
		
		
	}

	

	
}