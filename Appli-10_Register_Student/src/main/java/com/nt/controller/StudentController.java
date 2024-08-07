package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Student;
import com.nt.service.IService;

@Controller
public class StudentController {
	@Autowired
	private IService serivce;

	 @GetMapping("/")
	 public String showHome(Map<String, Object> map) {
       List<Student> list = serivce.showAllStu();
       map.put("stulist", list);
		 return "display";
	 }
	 @GetMapping("/addstu")
	 public String home() {
		 return "home";
	 }	
	 @PostMapping("/register")
	 public String registerStudent(Map<String, Object> map,@ModelAttribute("stu")Student stu) {
		 serivce.saveStu(stu);
		 return "redirect:/";
	 }
	 
	 @GetMapping("/edit")
	 public String getEditForm(@RequestParam("id")int id,@ModelAttribute("student")Student student) {
		 Student stu = serivce.findStudentById(id);
		 BeanUtils.copyProperties(stu, student);
		 return "editform";
	 }
	 
	 @PostMapping("/update")
	 public String updateStudent(@ModelAttribute("student")Student student) {
		 System.out.println(student);
		serivce.editStudent(student);
		 return "redirect:/";
	 }
	 
	 @GetMapping("/delete")
	 public String deleteStudent(@RequestParam("id")int id) {
		 serivce.deleteStudent(id);
		 return "redirect:/";
	 }
}
