package com.springboot.bloggerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.bloggerapp.domain.User;
import com.springboot.bloggerapp.service.UserService;

@Controller
public class BloggerAppController {

	private UserService userService;

	@Autowired
	public BloggerAppController(UserService userService) {
		this.userService = userService;
		setDefaultUser();
		System.out.println(userService.findUserByUsername("admin"));
	}

	@GetMapping(value = "/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.isAuthenticated()) auth.setAuthenticated(false);
		return "Login";
	}	

	private void setDefaultUser() {
		User user = new User("admin", "1234", 1);
		userService.save(user);
	}
	
}
