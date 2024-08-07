package com.nt.dto;

import java.util.ArrayList;
import java.util.List;

import com.nt.entity.Product;

public class Cart {

	 public static List<Product> cart;
	 static {
		 cart=new ArrayList<Product>();
	 }
}
