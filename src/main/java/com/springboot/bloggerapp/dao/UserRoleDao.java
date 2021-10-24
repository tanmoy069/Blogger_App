package com.springboot.bloggerapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bloggerapp.domain.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer>{
	
	UserRole findByRoleId(int roleId);

}
