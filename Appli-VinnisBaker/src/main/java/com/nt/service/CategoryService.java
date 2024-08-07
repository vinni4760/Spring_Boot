package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Category;
import com.nt.repository.CategoryRepo;

@Service
public class CategoryService implements IService {
	@Autowired
	private CategoryRepo repo;

	@Override
	public void addCategory(Category cat) {
		repo.save(cat);
	}

	@Override
	public List<Category> getallcategories() {
	  return	repo.findAll();
	
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Category getByid(Integer id) {
		return repo.findById(id).get();
	}

}
