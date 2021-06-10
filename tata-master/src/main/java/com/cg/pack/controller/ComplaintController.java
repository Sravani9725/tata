package com.cg.pack.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pack.entities.Complaint;
import com.cg.pack.exception.ComplaintNotFoundException;
import com.cg.pack.service.IComplaintService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	
	Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private IComplaintService service; 

	

	@GetMapping("/getById{id}")
	@ApiOperation("Get Compliant By Id")
	public Complaint FetchById(@PathVariable String id) throws ComplaintNotFoundException {
		logger.info("Complaint is been Proccessed by Team of complaint_id "+ id);
		return service.fetchById(Long.valueOf(id));

	}

	@GetMapping("/getAll")
	@ApiOperation("Fetch all Complaints by Details")
	public List<Complaint> fetch() {
		logger.info("Fetching all Complaints");
		
		return service.fetchAll();

	}

	@PostMapping("/save")
	@ApiOperation("Raise a Complaint")
	public void save(@Valid @RequestBody Complaint complaint) {
		logger.info("Complaint has registered" + complaint);
		service.addComplaint(complaint);
		
	}


	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete the resolved Complaint by Id")
	public void delete(@PathVariable String id) throws ComplaintNotFoundException {
		logger.info("Complaint has been Closed");
		service.delComplaint(Integer.valueOf(id));
	}
}