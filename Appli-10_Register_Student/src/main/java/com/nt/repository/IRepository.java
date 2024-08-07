package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Student;

public interface IRepository extends JpaRepository<Student, Integer>{

}
