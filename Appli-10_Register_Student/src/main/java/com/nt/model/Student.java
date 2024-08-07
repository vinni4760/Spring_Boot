package com.nt.model;

import org.springframework.web.bind.annotation.RequestMapping;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Student {
 
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	  private Integer id;
	 @NonNull
	 private String firstname;
	 @NonNull
	 private String lastname;
	 @NonNull
	 private String enroll;
	 @NonNull
	 private String email;
	 @NonNull
	 private Long contact;
	 @NonNull
	 private String course;
	 
	public boolean isEmpty() {
		// TODO Auto-generated method stub1
		
	      if (firstname==null||lastname==null||email==null) {
			return true;
		} else {
            return false;
		}
	}
	
}
