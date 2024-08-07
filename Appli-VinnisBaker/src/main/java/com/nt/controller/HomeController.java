package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.Category;
import com.nt.entity.Product;
import com.nt.entity.User;
import com.nt.service.CategoryService;
import com.nt.service.IProductService;
import com.nt.service.IService;
import com.nt.service.IUserService;

@Controller
public class HomeController {
	@Autowired
	private IService catservice;
	@Autowired
	private IProductService proservice;
	@Autowired
	private IUserService userservice;

	 @GetMapping("/")
	 public String showhomepage() {
		 return "index";
	 }
	 
	 @GetMapping("/shop")
	 public String shop(Map<String, Object> map) {
		 map.put("categories",catservice.getallcategories());
		 map.put("products", proservice.getAllProduct());
		 return "shop";
	 }
	 
	 @GetMapping("/shop/category")
	 public String showcategory(@RequestParam("id")Integer id,Map<String, Object> map) {
		
		 Category category= catservice.getByid(id);
	 List<Product> productlist=	 proservice.getByCategory(category);
		 map.put("products", productlist);
		 return "shop";
	 }
	 
	 @GetMapping("/shop/viewproduct")
	 public String veiwproduct(@RequestParam("id")Integer id,Map<String, Object> map) {
		 System.out.println(id);
		 map.put("product", proservice.findProduct(id));
		 return "veiwproduct";
	 }
	 

}
