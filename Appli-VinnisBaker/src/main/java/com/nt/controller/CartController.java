package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dto.Cart;
import com.nt.entity.Product;
import com.nt.service.IProductService;

@Controller
public class CartController {
	@Autowired
	private IProductService productservice;
	 @GetMapping("/addToCart")
	    public String showcart(@RequestParam("id")Integer id) {
		  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication == null || !authentication.isAuthenticated()) {
	            System.out.println("User is not authenticated");
	            return "redirect:/login";
	        }
	        System.out.println("User is authenticated: " + authentication.getName());
	        Product product = productservice.findProduct(id);
	        Cart.cart.add(product);
	        return "redirect:/shop";
		 }
	 
	 @GetMapping("/cart")
	 public String cart(Map<String, Object> map) {
		 map.put("cartCount", Cart.cart.size());
		 map.put("total", Cart.cart.stream().mapToDouble(Product::getPrice).sum());
		 map.put("cart", Cart.cart);
		 return "cart";
	 }
	 
	 @GetMapping("/cart/removeItem")
	 public String removeItem(@RequestParam("index")int index) {
		  Cart.cart.remove(index);
		 return "redirect:/cart";
	 }

}
