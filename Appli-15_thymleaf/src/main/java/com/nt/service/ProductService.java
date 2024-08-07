package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Product;
import com.nt.reposiotory.ProRepo;

@Service
public class ProductService implements IService{
	@Autowired
	private ProRepo repo;

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		repo.save(product);
	}

	@Override
	public List<Product> showAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product findProductByID(Integer id) {
		// TODO Auto-generated method stub
 	 	return repo.findById(id).get();

	}

	@Override
	public void deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
