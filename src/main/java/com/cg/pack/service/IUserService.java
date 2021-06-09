package com.cg.pack.service;

import com.cg.pack.entities.User;
import com.cg.pack.exception.UserNotFoundException;

public interface IUserService {
	User register(User user);
	User update(User user);
	User fetchById(long userId) throws UserNotFoundException;
	User findByUsername(String username);
	void deleteByUserId(long userId) throws UserNotFoundException;
	Long addRecharge(long recharge);
}
