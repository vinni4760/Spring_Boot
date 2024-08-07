package com.nt.service;

import java.util.List;

import com.nt.model.Student;

public interface IService {
	
	public List<Student> showAllStu();
   public void  saveStu(Student stu);
   public Student findStudentById(int id);
   public void editStudent(Student student);
   public void deleteStudent(int id);
   public String getSubject(Student stu);
   public String getText(Student stu);
//   public Boolean checkempty();
}
