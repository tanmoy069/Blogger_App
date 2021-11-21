package com.springboot.bloggerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bloggerapp.dao.UserDao;
import com.springboot.bloggerapp.domain.User;

@Service
public class UserService extends AbstractService<User>{
	
	private UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	@Override
	public boolean save(User user) {
		try {
			userDao.save(user);
			LOGGER.info("Successfully save username: " + user.getUsername());
			return true;
		} catch(Exception e) {
			LOGGER.info("Failed to save username: " + user.getUsername());
			return false;
		}
	}

	@Override
	public User findById(int id) {
		return userDao.findByUserId(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public boolean update(User obj) {
		try {
			if(findById(obj.getUserId()) != null) {
				userDao.save(obj);
				LOGGER.info("Successfully updated user: " + obj.getUserId());
				return true;
			}
			LOGGER.info("Unable to update user, user doesn't exists");
			return false;
		} catch(Exception e) {
			LOGGER.info("Failed to update user");
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			if(findById(id) != null) {
				userDao.deleteById(id);
				LOGGER.info("Successfully deleted user: " + id);
				return true;
			}
			LOGGER.info("Unable to delete user, user doesn't exists");
			return false;
		} catch(Exception e) {
			LOGGER.info("Failed to delete user");
			return false;
		}
	}

}
