package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Category;
import com.nt.entity.Product;
import com.nt.repository.ProductRepo;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepo repo;
	

	@Override
	public void saveproduct(Product product) {
		repo.save(product);
		
	}

	@Override
	public List<Product> getAllProduct() {		
		return repo.findAll();
	}

	@Override
	public Product findProduct(Integer id) {
//		repo.findById(id).get().getCategory().getName()
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public List<Product> getByCategory(Category category) {
	
	// TODO Auto-generated method stub
	   return repo.findByCategory(category);
	  
		
	}
	
	
}
