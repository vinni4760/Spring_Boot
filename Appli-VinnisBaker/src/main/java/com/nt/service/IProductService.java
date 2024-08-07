package com.nt.service;

import java.util.List;

import com.nt.entity.Category;
import com.nt.entity.Product;

public interface IProductService {

	 public void saveproduct(Product product);
	 public List<Product> getAllProduct();
	 public Product findProduct(Integer id);
	public void delete(Integer id);
	public List<Product> getByCategory(Category category);
}
