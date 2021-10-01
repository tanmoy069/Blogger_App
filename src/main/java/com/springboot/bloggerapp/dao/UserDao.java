package com.springboot.bloggerapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bloggerapp.domain.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByUserId(int id);
	User findByUsername(String username);

}
