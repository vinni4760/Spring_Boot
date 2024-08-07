package com.nt.dto;

import com.nt.entity.Category;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private Integer id;
	private String name;
	private Double price;
	private Double weight;
	private Integer categoryid;
	@Column(length = 1000)
	 private String description;
	
	private String imagename;

}
