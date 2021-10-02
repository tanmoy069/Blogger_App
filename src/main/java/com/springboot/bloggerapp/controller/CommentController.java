package com.springboot.bloggerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bloggerapp.domain.User;
import com.springboot.bloggerapp.service.BlogService;
import com.springboot.bloggerapp.service.CommentService;
import com.springboot.bloggerapp.service.UserService;

@Controller
@RequestMapping("/blog/comments")
public class CommentController {

	private UserService userService;
	private BlogService blogService;
	private CommentService commentService;

	@Autowired
	public CommentController(UserService userService, BlogService blogService, CommentService commentService) {
		this.userService = userService;
		this.blogService = blogService;
		this.commentService = commentService;
	}

	@GetMapping("/by")
	public String getBlogToComment(Model model, @RequestParam(name = "blogId", required = true) int blogId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("blog", blogService.findById(blogId));
		model.addAttribute("userDetails", user);
		return "BlogToComments";
	}

}
