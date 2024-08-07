package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.UserRepository;
@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("User name\s:"+username);
	 User user =  repo.findByEmail(username);
	 System.out.println("User:\s"+user);
	 if (user == null) {
         throw new UsernameNotFoundException("User not found");
     }
	 return user;
	}

}
