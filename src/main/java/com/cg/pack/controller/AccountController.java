package com.cg.pack.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pack.entities.Account;
import com.cg.pack.entities.Pack;
import com.cg.pack.exception.AccountNotFoundException;
import com.cg.pack.exception.PackNotFoundException;
import com.cg.pack.service.IAccountService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Account")
public class AccountController {
	Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private IAccountService service;

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings() {
		logger.info("Inside Greetings");
		return "<h1>Welcome to TataSky Project</h1>";
	}

	@PostMapping("/save")
	@ApiOperation("Add new Account")
	public ResponseEntity<Account> save(@Valid @RequestBody Account account) {
		logger.info("creating an account for user " + account);
		Account acc = service.addAccount(account);
		return new ResponseEntity<>(acc, HttpStatus.CREATED);

	}

	@GetMapping("/getById/{id}")
	@ApiOperation("Get the Account By Id")
	public Account fetchById(@PathVariable long id) throws AccountNotFoundException, NumberFormatException {
		logger.info("Inside fetchById %s", id);

		return service.fetchById(id);

	}

	@PutMapping("/update")
	@ApiOperation("Update an Existing Account Details")
	public Account updateAccount(@PathVariable Account account) throws AccountNotFoundException {
		logger.info("Updating the Existing Account " + account);
		return service.updateAccount(account);

	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete the Account of the User using Id")
	public ResponseEntity<Void> deleteAccountById(@PathVariable long id) throws AccountNotFoundException {
		logger.info("Deleting the Account of the User");
		service.deleteByAccountId(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

//	@GetMapping("/countAccounts")
//	@ApiOperation("Counts number of user registered in a peroid of time")
//	public int countCreatedAccountsinPeriod(@PathVariable LocalDate startdate, @PathVariable LocalDate enddate) {
//		logger.info("Counts number of user registered in a peroid of time");
//		return service.countCreatedAccountsInPeriod(startdate, enddate);
//	}

	@GetMapping("/getCountOfAccounts")
	@ApiOperation("Get count of all the Accounts")
	public int countAccounts() {
		logger.info("Get count of all the Accounts");
		return service.countAccounts();

	}

	@PutMapping("/deletePackOfAccount/{accountid-packid}")
	public ResponseEntity<Void> removePackFromAccount(@PathVariable Account account, @PathVariable Pack pack)
			throws AccountNotFoundException, PackNotFoundException {
		logger.info("Deleting the particular pack from the User  Account");
		service.removePackFromAccount(account, pack);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

}
