package com.springboot.bloggerapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bloggerapp.domain.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>  {
	
	Category findById(int id);
}
