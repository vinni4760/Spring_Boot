package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	 @GetMapping("/home")
	 public String showhome() {
		 return "Welcome to home page";
	 }
	 
	 @GetMapping("/balance")
		public String checkbalance() {
			String msg = "Your balance is 450000";
			
			return msg;
		}
		@GetMapping("/loan")
		public String getloanamount() {
			String msg = "loan amount is 45.0000";
			return msg;
		}
		@GetMapping("/contact")
		public String contactus() {
			String msg = "Contact us for more info on 1800-9600-5600";
			return msg;
		}
	

}
