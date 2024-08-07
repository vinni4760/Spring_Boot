package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nt.model.Student;
import com.nt.repository.IRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Serviceimpl implements IService {

	@Autowired
	private IRepository repo;
	@Autowired
	private JavaMailSender mailsender;
	@Value("${spring.mail.username}")
	private String sender;
	@Override
	public void saveStu(Student stu) {
		repo.save(stu);
		// TODO Auto-generated method stub
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setFrom(sender);
			helper.setTo(stu.getEmail());
			helper.setSubject(getSubject(stu));
			helper.setText(getText(stu));
			mailsender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
		System.out.println("student registered");
	}
	@Override
	public List<Student> showAllStu() {
 	  return	repo.findAll();

	}
	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	@Override
	public void editStudent(Student student) {
		// TODO Auto-generated method stub
		repo.save(student);
		
	}
	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
	@Override
	public String getSubject(Student stu) {
		
		return "Registration Successfull";
	}
	@Override
	public String getText(Student stu) {
		System.out.println(stu.getFirstname()+stu.getId());
		return "Dear\s"+stu.getFirstname()+"\syou have successfully registered with id\s"+stu.getId();
	}
	

}
