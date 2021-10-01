package com.springboot.bloggerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bloggerapp.dao.BlogDao;
import com.springboot.bloggerapp.domain.Blog;

@Service
public class BlogService extends AbstractService<Blog> {

	private BlogDao blogDao;

	@Autowired
	public BlogService(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@Override
	public Blog findById(int id) {
		return blogDao.findByBlogId(id);
	}

	@Override
	public List<Blog> findAll() {
		return blogDao.findAll();
	}
	
	public List<Blog> findAllByUsername(String username) {
		return blogDao.findByUsername(username);
	}
	
	public List<Blog> findAllApproveBlogs() {
		return blogDao.findByIsApprove(true);
	}
	
	public List<Blog> findAllWaitingForApprovalBlogs() {
		return blogDao.findByIsCompleteApproval(false);
	}	

	@Override
	public boolean save(Blog obj) {
		try {
			blogDao.save(obj);
			LOGGER.info("Successfully post blog of userid : " + obj.getUsername());
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to post");
			return false;
		}
	}

	@Override
	public boolean update(Blog obj) {
		try {
			if(findById(obj.getBlogId()) != null) {
				blogDao.save(obj);
				LOGGER.info("Successfully updated blog: " + obj.getBlogId());
				return true;
			}
			LOGGER.info("Unable to update blog, blog doesn't exists");
			return false;
		} catch(Exception e) {
			LOGGER.info("Failed to update blog");
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			if(findById(id) != null) {
				blogDao.deleteById(id);
				LOGGER.info("Successfully deleted blog: " + id);
				return true;
			}
			LOGGER.info("Unable to delete blog, blog doesn't exists");
			return false;
		} catch(Exception e) {
			LOGGER.info("Failed to delete blog");
			return false;
		}
	}

}
