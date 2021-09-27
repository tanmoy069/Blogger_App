package com.springboot.bloggerapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.bloggerapp.domain.User;

public interface UserDao extends CrudRepository<User, Integer> {

}
