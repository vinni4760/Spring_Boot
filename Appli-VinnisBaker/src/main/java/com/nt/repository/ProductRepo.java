package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Category;
import com.nt.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	 public List<Product> findByCategory(Category category);
}
