package com.cg.pack.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pack.entities.User;
import com.cg.pack.exception.UserNotFoundException;
import com.cg.pack.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repository;

	@Override
	public User register(User user) {
		logger.info("inside register method");
		return repository.save(user);
	}

	@Override
	public void deleteByUserId(long userId) throws UserNotFoundException {
		Optional<User> user = repository.findById(userId);
		if (!user.isPresent())
			throw new UserNotFoundException();

		repository.deleteById(userId);
	}

	@Override
	public User update(User user) {
		return repository.save(user);
	}

	@Override
	public User fetchById(long userId) throws UserNotFoundException {
		Optional<User> user = repository.findById(userId);
		if (!user.isPresent())
			throw new UserNotFoundException();

		return user.get();
	}

	@Override
	public User findByUsername(String username) {
		return repository.getByUsername(username);
	}

	@Override
	public Long addRecharge(long recharge) {
		// TODO Auto-generated method stub
		return null;
	}


}
