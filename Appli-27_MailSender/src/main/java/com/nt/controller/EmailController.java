package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Email;
import com.nt.service.MailService;

@Controller
public class EmailController {
	
	@Autowired
	private MailService service;
	
	@GetMapping("/")
	public String showHome(Map<String, Object> map) {
		map.put("email", new Email());
		return "Home";
	}
	
	@PostMapping("/send")
	public String sendMail(@ModelAttribute("mail")Email mail) {
		System.out.println(mail);
		service.sendMail(mail);
		return "redirect:/";
	}
	

}
