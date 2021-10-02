package com.springboot.bloggerapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bloggerapp.domain.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer>{
	
	Comment findByCommentId(int id);
	List<Comment> findByBlogId(int blogId);

}
