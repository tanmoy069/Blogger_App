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
import org.springframework.web.bind.annotation.RequestParam;

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
		
		if(currUser.getRoleId() == 1) {
			user.setActive(true);
			user.setCompleteApproval(true);
		}
		
		boolean isSave = userService.save(user);
		if (isSave) model.addAttribute("successful", true);
		else model.addAttribute("unsuccessful", true);
		return "Registration";
	}
	
	@GetMapping(value = "/update")
	public String getUserList(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("userDetails", user);
		model.addAttribute("userList", userService.findAll());
		return "UserList";
	}
	
	@GetMapping("/active")
	public String getUserActiveForm(Model model, @RequestParam(name = "userId", required = true) int userId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("userDetails", user);
		User activeUser = userService.findById(userId);
		activeUser.setActive(true);
		activeUser.setCompleteApproval(true);
		userService.update(activeUser);
		model.addAttribute("userList", userService.findAll());
		return "redirect:/user/update";
	}
	
	@GetMapping("/deactivate")
	public String getUserDeactivateForm(Model model, @RequestParam(name = "userId", required = true) int userId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("userDetails", user);
		User deactivateUser = userService.findById(userId);
		deactivateUser.setActive(false);
		userService.update(deactivateUser);
		model.addAttribute("deactivateUser", userService.findById(userId));
		return "redirect:/user/update";
	}
	
	
	

}
