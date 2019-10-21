package com.wipro.hca.vendingmachine.service;

import java.util.List;

import com.wipro.hca.vendingmachine.entity.User;

public interface UserService {
	public User findUserByEmail(String email) ;
	public User saveUser(User user);
	public User updateAccountBalance(User user);
	public List<User> getUsers();
}
