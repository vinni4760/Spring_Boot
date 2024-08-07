package com.nt.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.User;
import com.nt.service.IUserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	private IUserService userservice;
	
	@Autowired
	private PasswordEncoder encoder;
	
	 @GetMapping("/login")
	 public String showlogin() {
		 return "login";
	 }
	 
	 @PostMapping("/custom-login")
	 public String login(@RequestParam("email") String username, @RequestParam("password") String password) {
	     // Check if username is null or empty
	     if (username == null || username.isEmpty()) {
	         System.out.println("Username is null or empty");
	         return "login"; // Return to login page with an error
	     }
	     // Authenticate the user
	     // ...
	     return "redirect:/"; // Redirect on successful login
	 }

	 
	 
	 @GetMapping("/register")
	 public String  register(Map<String,Object> map) {
		 map.put("user", new User());
		 return "register";
	 }
	 
	 @PostMapping("/signup")
	 public String registUser(@ModelAttribute("user")User user , HttpServletRequest request) throws ServletException {
		 String password =user.getPassword();
		 System.out.println(password);
		 user.setPassword(encoder.encode(password));
		 Set<String> roles = new HashSet<>();
	        roles.add("ADMIN");
	        user.setRoles(roles);
		 userservice.addUser(user);
		 request.login(user.getEmail(),password);
		 return "redirect:/";
	 }
	 
	 

}
