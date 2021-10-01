package com.springboot.bloggerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.bloggerapp.dao.BlogDao;
import com.springboot.bloggerapp.domain.Blog;

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

	@Override
	public boolean save(Blog obj) {
		try {
			blogDao.save(obj);
			LOGGER.info("Successfully post blog of userid : " + obj.getUserId());
			return true;
		} catch (Exception e) {
			LOGGER.info("Failed to post");
			return false;
		}
	}

	@Override
	public boolean update(Blog obj) {
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		return false;
	}

}
