package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
