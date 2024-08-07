package com.nt.reposiotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Product;

public interface ProRepo extends JpaRepository<Product, Integer> {

}
