package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {

	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE)
	   private Integer id;
	  
	  private String name;
	  private Integer quantity;
}
