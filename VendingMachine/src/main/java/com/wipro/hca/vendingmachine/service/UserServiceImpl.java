package com.wipro.hca.vendingmachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.hca.vendingmachine.entity.Role;
import com.wipro.hca.vendingmachine.entity.User;
import com.wipro.hca.vendingmachine.repository.RoleRepository;
import com.wipro.hca.vendingmachine.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public User updateAccountBalance(User user) {
		Integer itemsUpdatedNo = userRepository.updateAccountBalance(user.getAccountBalance(), user.getEmail());
		if (itemsUpdatedNo > 0) {
			return user;
		} else {
			return user;
		}
	}
}
