package com.springboot.bloggerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bloggerapp.dao.UserDao;
import com.springboot.bloggerapp.domain.User;

@Service
public class UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
