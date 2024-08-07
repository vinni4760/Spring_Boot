package com.nt.service;

import java.util.List;

import com.nt.model.Product;

public interface IService {
	
	public List<Product> showAllProduct();
	 public void insertProduct(Product product);
	 public Product findProductByID(Integer id);
	 public void deleteProductById(Integer id);

}
