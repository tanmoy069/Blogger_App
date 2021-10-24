package com.springboot.bloggerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.bloggerapp.dao.CategoryDao;
import com.springboot.bloggerapp.domain.Category;

public class CategoryService extends AbstractService<Category>{

	private CategoryDao catDao;
	
	@Autowired
	public CategoryService(CategoryDao catDao) {
		this.catDao = catDao;
	}
	
	@Override
	public Category findById(int id) {
		return catDao.findById(id);
	}

	@Override
	public List<Category> findAll() {
		return catDao.findAll();
	}

	@Override
	public boolean save(Category obj) {
		try {
			if(findById(obj.getId()) == null) {
				catDao.save(obj);
				LOGGER.info("Successfully added Category");
				return true;
			}
			LOGGER.info("Category id: " + obj.getId() + " already exists");
			return false;
		} catch (Exception e) {
			LOGGER.info("Failed to add Category");
			return false;
		}
	}

	@Override
	public boolean update(Category obj) {
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			if(findById(id) != null) {
				catDao.deleteById(id);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

}
