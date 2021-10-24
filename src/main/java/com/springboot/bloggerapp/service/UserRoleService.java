package com.springboot.bloggerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.bloggerapp.dao.UserRoleDao;
import com.springboot.bloggerapp.domain.UserRole;

public class UserRoleService extends AbstractService<UserRole>{

	private UserRoleDao userRoleDao;
	
	@Autowired
	public UserRoleService(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	@Override
	public UserRole findById(int id) {
		return userRoleDao.findByRoleId(id);
	}

	@Override
	public List<UserRole> findAll() {
		return userRoleDao.findAll();
	}

	@Override
	public boolean save(UserRole obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserRole obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
