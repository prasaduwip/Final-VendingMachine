package com.wipro.hca.vendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.hca.vendingmachine.entity.User;
import com.wipro.hca.vendingmachine.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginForm");
		return modelAndView;
	}

	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registrationForm");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
			.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registrationForm");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registrationForm");
		}
		return modelAndView; 
	}

	@RequestMapping(value="/vendingmachine", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ObjectMapper objectMapper = new ObjectMapper();
		modelAndView.addObject("userName", user.getName());
		modelAndView.addObject("accountBalance", user.getAccountBalance());
		try {
			modelAndView.addObject("user", objectMapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		modelAndView.setViewName("home");
		return modelAndView; 
	}
	
	@PostMapping(value="/vendingmachine/updateAccountBalance")
	public ResponseEntity<User> updateAccountBalance(@RequestBody User user) {
		user = userService.updateAccountBalance(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping(value="/vendingmachine/getUsers")
	public ModelAndView getUsers() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", userService.getUsers());
		modelAndView.setViewName("users");
		return modelAndView; 
	}

}
