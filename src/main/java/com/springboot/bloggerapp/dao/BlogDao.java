package com.springboot.bloggerapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bloggerapp.domain.Blog;

public interface BlogDao extends JpaRepository<Blog, Integer>{
	
	Blog findByBlogId(int id);

}
