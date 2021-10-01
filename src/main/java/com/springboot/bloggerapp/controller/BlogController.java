package com.springboot.bloggerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.bloggerapp.domain.User;
import com.springboot.bloggerapp.service.BlogService;
import com.springboot.bloggerapp.service.UserService;

@Controller
public class BlogController {
	
	@Autowired private UserService userService;
	@Autowired private BlogService blogService;
	
	@GetMapping(value="/")
	public String redirectHome(Model model) {
		return getHome(model);
	}
	
	@GetMapping(value="/home")
	public String getHome(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("blogList", blogService.findAll());
		model.addAttribute("userDetails", user);
		return "Home";
	}


}
