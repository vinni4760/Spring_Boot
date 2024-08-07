package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Product;
import com.nt.service.IService;


@Controller
public class ProductController {
	@Autowired
	private IService service;
	
	@GetMapping("/")
	public String showHome(Map<String, Object> map) {
	  List<Product> productList=	service.showAllProduct();
		map.put("productList", productList);
	  return "displayProduct";
	}
	@GetMapping("/product")
	public String addProduct(Model model) {
		model.addAttribute("product",new Product());
		return "home";
	}
	
	
	@PostMapping("/submitForm")
	public String submit(Map<String, Object> map,@ModelAttribute("product")Product product) {
		service.insertProduct(product);
		map.put("product", product.getId());
		return "submit";
	}
	
	@GetMapping("/update")
	public String showupdateform(@RequestParam("id")Integer id,Map<String, Object> map) {
	  Product product=	service.findProductByID(id);
	   map.put("product", product);
	  return "update";
	}
	
	@PostMapping("/edit")
	public String updateProduct(@ModelAttribute("product")Product product) {
		service.insertProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id")Integer id) {
		service.deleteProductById(id);
		return "redirect:/";
	}
	

	 
}
