package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Email {
	
	private String to;
	private String subject;
	private String message;

	 
}
