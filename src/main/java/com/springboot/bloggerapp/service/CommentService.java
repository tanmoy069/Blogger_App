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
	
	public List<Comment> findByBlogId(int blogId){
		return commentDao.findByBlogId(blogId);
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
		try {
			if(findById(obj.getCommentId()) != null) {
				commentDao.save(obj);
				LOGGER.info("Successfully updated comment of blogid : " + obj.getBlogId());
				return true;
			}
			LOGGER.info("Comment doesn't exist");
			return false;
		} catch (Exception e) {
			LOGGER.info("Failed to update comment");
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			if(findById(id) != null) {
				commentDao.deleteById(id);
				LOGGER.info("Successfully deleted comment of commentId: " + id);
				return true;
			}
			LOGGER.info("Comment doesn't exist");
			return false;
		} catch (Exception e) {
			LOGGER.info("Failed to delete comment");
			return false;
		}
	}

}
