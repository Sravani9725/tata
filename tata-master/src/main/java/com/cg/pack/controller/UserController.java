package com.cg.pack.controller;



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

import com.cg.pack.entities.User;
import com.cg.pack.exception.UserNotFoundException;
import com.cg.pack.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {
	

		Logger logger = LoggerFactory.getLogger(UserController.class);

		@Autowired
		private IUserService service;

		

		@GetMapping("/getById/{userId}")
		@ApiOperation("Get User By ID")
		public User fetchById(@PathVariable long userId) throws NumberFormatException, UserNotFoundException {
			logger.info("Inside fetchById %s", userId);
			return service.fetchById(userId);
		}

		@PostMapping("/register")
		@ApiOperation("Add a User Record")
		public ResponseEntity<User> save(@Valid @RequestBody User user) {
			logger.info("Adding a user : " + user);
			service.register(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		
		
		@PutMapping("/update")
		@ApiOperation("Update an Existing User Record")
		public void update(@Valid @RequestBody User user) {
			logger.info("Updating a user!!");
			service.update(user);
		}

		@DeleteMapping("/delete/{userId}")
		@ApiOperation("Delete an Existing User Record")
		public ResponseEntity<Void> delete(@PathVariable long userId) throws UserNotFoundException {
			logger.info("Deleting a user!!");
			service.deleteByUserId(userId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		@GetMapping("findByUserName/{uname}")
		@ApiOperation("Find user by user name")
		public User findUserByUserName(@PathVariable String uname) {
			return service.findByUsername(uname);
		}

		

	}


