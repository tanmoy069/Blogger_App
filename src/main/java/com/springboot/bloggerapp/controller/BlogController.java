package com.springboot.bloggerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.bloggerapp.domain.Blog;
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
		model.addAttribute("blogList", blogService.findAllApproveBlogs());
		model.addAttribute("userDetails", user);
		return "Home";
	}
	
	@PostMapping(value="/home")
	public String setStatus(Model model, @ModelAttribute("statuPostForm") Blog blog) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("blogList", blogService.findAll());
		model.addAttribute("userDetails", user);
		blog.setUsername(user.getUsername());		
		blogService.save(blog);
		return "redirect:/home";
	}
	
	@GetMapping(value="/blog/approvalList")
	public String getApproveList(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("userDetails", user);
		model.addAttribute("blogList", blogService.findAllWaitingForApprovalBlogs());
		return "ApproveBlogs";
	}
	
	@GetMapping(value="/blog/approve")
	public String setApproveBlog(Model model, @RequestParam(name="blogId", required = true) int blogId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		Blog blog = blogService.findById(blogId);
		blog.setIsApprove(true);
		blog.setCompleteApproval(true);
		blogService.update(blog);
		return "redirect:/blog/approvalList";
	}
	
	@GetMapping(value="/blog/denied")
	public String setDeniedBlog(Model model, @RequestParam(name="blogId", required = true) int blogId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		Blog blog = blogService.findById(blogId);
		blog.setIsApprove(false);
		blog.setCompleteApproval(true);
		blogService.update(blog);
		return "redirect:/blog/approvalList";
	}
	
	@GetMapping(value="/blog/deleteList")
	public String getDeleteBlogList(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!auth.isAuthenticated()) return "Login";
		User user = userService.findUserByUsername(auth.getName());
		model.addAttribute("userDetails", user);
		if(user.getRoleId()==1) {
			model.addAttribute("blogList", blogService.findAllApproveBlogs());
		} else {
			model.addAttribute("blogList", blogService.findAllByUsername(user.getUsername()));
		}
		return "DeleteBlogList";
	}


}
