package com.springboot.bloggerapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bloggerapp.domain.Blog;

public interface BlogDao extends JpaRepository<Blog, Integer> {

	Blog findByBlogId(int id);

	List<Blog> findByIsCompleteApproval(boolean isCompeleteApproval);

	List<Blog> findByIsApprove(boolean isApprove);

	List<Blog> findByUsername(String username);

}
