package com.springboot.bloggerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.bloggerapp.domain.User;
import com.springboot.bloggerapp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/registration")
	public String getRegistrationFrom(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("userDetails", user);
		return "Registration";
	}
	
	@PostMapping(value = "/registration")
	public String submitRegistration(Model model, @ModelAttribute("userRegiForm") User user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User currUser = userService.findUserByUsername(auth.getName());
		model.addAttribute("userDetails", currUser);
		model.addAttribute("regiRequest", true);
		
		boolean isSave = userService.save(user);
		if (isSave) model.addAttribute("successful", true);
		else model.addAttribute("unsuccessful", true);
		return "Registration";
	}

}
