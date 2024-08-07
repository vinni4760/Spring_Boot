package com.nt.service;

import java.util.List;

import com.nt.entity.Category;

public interface IService {

	 public void addCategory(Category cat);

	public List<Category> getallcategories();

	public void delete(Integer id);
	 
	public Category getByid(Integer id);
}
