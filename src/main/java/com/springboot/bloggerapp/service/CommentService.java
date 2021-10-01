package com.springboot.bloggerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bloggerapp.dao.CommentDao;
import com.springboot.bloggerapp.domain.Comment;

@Service
public class CommentService extends AbstractService<Comment> {
	
	private CommentDao commentDao; 
	
	@Autowired
	public CommentService(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public Comment findById(int id) {
		return commentDao.findByCommentId(id);
	}

	@Override
	public List<Comment> findAll() {
		return commentDao.findAll();
	}

	@Override
	public boolean save(Comment obj) {
		try {
			commentDao.save(obj);
			LOGGER.info("Successfully post comment of blogid : " + obj.getBlogId());
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to post");
			return false;
		}
	}

	@Override
	public boolean update(Comment obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
