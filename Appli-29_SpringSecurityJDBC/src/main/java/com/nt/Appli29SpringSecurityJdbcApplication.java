package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Appli29SpringSecurityJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Appli29SpringSecurityJdbcApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
